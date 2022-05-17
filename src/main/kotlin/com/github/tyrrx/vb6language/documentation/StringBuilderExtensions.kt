package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

fun StringBuilder.appendName(resolve: PsiNamedElement) {
    append(resolve.name)
}

fun StringBuilder.appendVisibility(resolve: VB6VisibilityOwner) {
    append(resolve.visibility.beautifulName)
}

fun StringBuilder.appendTypeInferable(resolve: VB6TypeInferable) {
    when (val inferenceResult = resolve.inferType()) {
        is InferenceResult.BaseType -> appendTypeName(inferenceResult.typeName)
        is InferenceResult.Unknown -> appendTypeName("Variant")
        is InferenceResult.UserDefinedType -> appendTypeName(inferenceResult.typeDeclaration.name)
    }
}

fun StringBuilder.appendFileName(element: PsiElement?) {
    element?.let {
        append(" [${element.containingFile.name}]")
    }
}

fun StringBuilder.appendTypeName(typeName: String?) {
    if (typeName != null) {
        append(" As")
        bold {
            append(" $typeName")
        }
    }
}

inline fun StringBuilder.definition(block: () -> Unit) {
    append(DocumentationMarkup.DEFINITION_START)
    block()
    append(DocumentationMarkup.DEFINITION_END)
}

inline fun StringBuilder.content(block: () -> Unit) {
    append("\n", DocumentationMarkup.CONTENT_START)
    block()
    append(DocumentationMarkup.CONTENT_END)
}

inline fun StringBuilder.whiteSpaceAfterThis(block: () -> Unit) {
    block()
    append(" ")
}

inline fun StringBuilder.whiteSpaceBeforeThis(block: () -> Unit) {
    append(" ")
    block()
}

inline fun StringBuilder.whiteSpaceSurrounded(block: () -> Unit) {
    append(" ")
    block()
    append(" ")
}

inline fun StringBuilder.bold(block: () -> Unit) {
    append("<b>")
    block()
    append("</b>")
}

inline fun StringBuilder.italic(block: () -> Unit) {
    append("<i>")
    block()
    append("</i>")
}

inline fun StringBuilder.code(block: () -> Unit) {
    append("<code>")
    block()
    append("</code>")
}

inline fun StringBuilder.sections(block: StringBuilder.() -> Unit) {
    append("\n", DocumentationMarkup.SECTIONS_START)
    block()
    append(DocumentationMarkup.SECTIONS_END)
}

inline fun StringBuilder.section(title: String, block: StringBuilder.() -> Unit) {
    append(DocumentationMarkup.SECTION_HEADER_START, title, ":", DocumentationMarkup.SECTION_SEPARATOR, "<p>")
    block()
    append(DocumentationMarkup.SECTION_END)
}