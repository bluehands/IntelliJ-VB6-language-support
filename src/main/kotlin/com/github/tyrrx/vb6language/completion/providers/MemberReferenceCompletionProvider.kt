package com.github.tyrrx.vb6language.completion.providers

import com.github.tyrrx.vb6language.psi.reference.VB6MemberReferenceOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class MemberReferenceCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
    ) {
        val pos = parameters.position
        val placeholderReferenceOwner = getPlaceholderReferenceOwner(pos)
        val previousReferenceOwner = getPreviousReferenceOwnerOf(placeholderReferenceOwner)
        val lookupElements = variantsOf(resolveReferenceOf(previousReferenceOwner))
                .map {
                    LookupElementBuilder.create(it)
                }

        result.withPrefixMatcher(".")
        result.addAllElements(lookupElements)
    }

    private fun resolveReferenceOf(previousReferenceOwner: VB6ReferenceOwner?) =
            previousReferenceOwner?.reference?.resolve()

    private fun getPreviousReferenceOwnerOf(referenceOwner: VB6ReferenceOwner?) =
            when (referenceOwner) {
                is VB6MemberReferenceOwner -> referenceOwner.previousReferenceOwner
                else -> null
            }

    private fun getPlaceholderReferenceOwner(pos: PsiElement) = when (val parent = pos.parent) {
        is VB6NamedElement -> parent.referenceOwner
        else -> null
    }

    private fun variantsOf(resolvedElement: PsiElement?): List<VB6NamedElementOwner> = when (resolvedElement) {
        is VB6TypeDeclaration -> resolvedElement.processTypeDeclarations(SuggestionTypeDeclarationVisitor())
        is VB6TypeInferable -> variantsOfInferable(resolvedElement)
        else -> emptyList()
    }

    private fun variantsOfInferable(resolvedElement: VB6TypeInferable) =
            when (val result = resolvedElement.inferType()) {
                is InferenceResult.UserDefinedType -> variantsOf(result.typeDeclaration)
                is InferenceResult.BaseType -> emptyList() // todo basic type methods
                is InferenceResult.Unknown -> emptyList() // todo
            }
}