package com.github.tyrrx.vb6language.completion.providers

import com.github.tyrrx.vb6language.completion.visitors.DeclarationSuggestionsCollectingVisitor
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.reference.visitor.acceptToContext
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6AtomicBlockCall
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6AtomicInlineCall
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Expression
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class DeclarationCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
    ) {
        val pos = parameters.position

        when (val placeholderReferenceOwner = getPlaceholderReferenceOwner(pos)) {
            is VB6AtomicInlineCall -> {
                val declarations = searchDeclarationsBefore(placeholderReferenceOwner)
                val filteredDeclarations = filterTypeInferableIfExpressionContext(placeholderReferenceOwner, declarations)
                addSuggestions(filteredDeclarations, result)
            }
            is VB6AtomicBlockCall -> addSuggestions(searchDeclarationsBefore(placeholderReferenceOwner), result)
        }
    }

    private fun filterTypeInferableIfExpressionContext(placeholderReferenceOwner: VB6AtomicInlineCall, declarations: List<VB6NamedElementOwner>) =
            if (placeholderReferenceOwner.parent.parent is VB6Expression) {
                declarations.filter { it is VB6TypeInferable }
            } else {
                declarations
            }

    private fun addSuggestions(declarations: List<VB6NamedElementOwner>, result: CompletionResultSet) {
        val suggestions = buildSuggestionText(declarations)
        result.withPrefixMatcher("")
        result.addAllElements(suggestions)
    }

    private fun searchDeclarationsBefore(placeholderReferenceOwner: VB6ReferenceOwner): List<VB6NamedElementOwner> {
        return placeholderReferenceOwner
                .acceptToContext(DeclarationSuggestionsCollectingVisitor(placeholderReferenceOwner))
                ?: emptyList()
    }

    private fun buildSuggestionText(declarations: List<VB6NamedElementOwner>): List<LookupElementBuilder> {
        return declarations.map { declaration ->
            val builder = LookupElementBuilder.create(declaration)
            when (declaration) {
                is VB6TypeInferable -> when (val typeResult = declaration.inferType()) {
                    is InferenceResult.BaseType -> builder.withTypeText(typeResult.typeName)
                    is InferenceResult.Unknown -> builder.withTypeText("Variant")
                    is InferenceResult.UserDefinedType -> builder.withTypeText(typeResult.typeDeclaration.name)
                }
                else -> builder
            }
        }
    }

    private fun getPlaceholderReferenceOwner(pos: PsiElement) = when (val parent = pos.parent) {
        is VB6NamedElement -> parent.referenceOwner
        else -> null
    }

}