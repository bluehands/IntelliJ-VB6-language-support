package com.github.tyrrx.vb6language.completion

import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.visitor.TypeDeclarationVisitor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
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
        val lookupElements = resolveVariants(resolveReferenceOf(previousReferenceOwner))
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

    private fun resolveVariants(resolvedElement: PsiElement?): List<VB6NamedElementOwner> = when (resolvedElement) {
        is VB6TypeDeclaration -> resolvedElement.processTypeDeclarations(SuggestionTypeDeclarationVisitor())
        is VB6TypeInferable -> resolveVariantsFromInferable(resolvedElement)
        else -> emptyList()
    }

    private fun resolveVariantsFromInferable(resolvedElement: VB6TypeInferable) =
            when (val result = resolvedElement.inferType) {
                is VB6TypeInferenceResult.ComplexTypeInferenceResult -> resolveVariants(result.typeReference?.resolve())
                is VB6TypeInferenceResult.BaseTypeInferenceResult -> emptyList() // todo basic type methods
                VB6TypeInferenceResult.Unknown -> emptyList() // todo
            }
}