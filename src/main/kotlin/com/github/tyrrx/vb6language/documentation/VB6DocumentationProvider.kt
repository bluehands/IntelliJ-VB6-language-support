package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.highlighting.VisualBasic6SyntaxHighlighter
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

/**
 * Implements the [DocumentationProvider] interface
 */

class VB6DocumentationProvider : AbstractDocumentationProvider() {

    override fun getQuickNavigateInfo(hoveredElement: PsiElement?, elementUnderTheCaret: PsiElement?): String? {
        return when (elementUnderTheCaret) {
            is VB6ReferenceOwner -> quickNavigationInfoFor(elementUnderTheCaret)
            else -> null
        }
    }

    private fun quickNavigationInfoFor(elementUnderTheCaret: VB6ReferenceOwner): String {
        return buildString {
            val resolve = elementUnderTheCaret.reference?.resolve()
            when (resolve) {
                is PsiNamedElement -> append(resolve.name)
            }
            when (resolve) {
                is VB6TypeInferable -> when (val inferenceResult = resolve.inferType()) {
                    is InferenceResult.BaseType -> appendTypeName(inferenceResult.typeName)
                    is InferenceResult.Unknown -> appendTypeName("Unknown")
                    is InferenceResult.UserDefinedType -> appendTypeName(inferenceResult.typeDeclaration.name)
                }
            }
            VisualBasic6SyntaxHighlighter.BACKGROUND.defaultAttributes.foregroundColor
            appendFileName(elementUnderTheCaret)
        }
    }


}

private fun StringBuilder.appendFileName(elementUnderTheCaret: VB6ReferenceOwner) {
    append(" [${elementUnderTheCaret.containingFile.name}]")
}

private fun StringBuilder.appendTypeName(typeName: String?) {
    if (typeName != null) {
        code {
            append(" As $typeName")
        }
    }
}

private inline fun StringBuilder.definition(block: () -> Unit) {
    append(DocumentationMarkup.DEFINITION_START)
    block()
    append(DocumentationMarkup.DEFINITION_END)
}

private inline fun StringBuilder.content(block: () -> Unit) {
    append("\n", DocumentationMarkup.CONTENT_START)
    block()
    append(DocumentationMarkup.CONTENT_END)
}

private inline fun StringBuilder.bold(block: () -> Unit) {
    append("<b>")
    block()
    append("</b>")
}

private inline fun StringBuilder.italic(block: () -> Unit) {
    append("<i>")
    block()
    append("</i>")
}

private inline fun StringBuilder.code(block: () -> Unit) {
    append("<code>")
    block()
    append("</code>")
}

private inline fun StringBuilder.sections(block: StringBuilder.() -> Unit) {
    append("\n", DocumentationMarkup.SECTIONS_START)
    block()
    append(DocumentationMarkup.SECTIONS_END)
}

private inline fun StringBuilder.section(title: String, block: StringBuilder.() -> Unit) {
    append(DocumentationMarkup.SECTION_HEADER_START, title, ":", DocumentationMarkup.SECTION_SEPARATOR, "<p>")
    block()
    append(DocumentationMarkup.SECTION_END)
}