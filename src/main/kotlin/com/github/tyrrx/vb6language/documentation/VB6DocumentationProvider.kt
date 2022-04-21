package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.psi.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.inference.InferenceResult
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.github.tyrrx.vb6language.psi.tree.definition.variable.*
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
            is VB6ReferenceOwner -> quickNavigationInfoFor(elementUnderTheCaret.reference?.resolve())
            else -> when (hoveredElement) {
                is VB6Identifier -> quickNavigationInfoFor(hoveredElement.namedElementOwner)
                else -> quickNavigationInfoFor(hoveredElement)
            }
        }
    }

    private fun quickNavigationInfoFor(element: PsiElement?): String? {
        return element?.let { resolve ->
            buildString {
                when (resolve) {
                    is VB6FunctionStatement -> {
                        appendVisibility(resolve)
                        bold { append(" Function ") }
                        appendName(resolve)
                        appendArguments(resolve)
                        appendTypeInferable(resolve)
                    }
                    is VB6SubroutineStatement -> {
                        appendVisibility(resolve)
                        bold { append(" Sub ") }
                        appendName(resolve)
                        appendArguments(resolve)
                    }
                    is VB6DeclareStmt -> {
                        appendVisibility(resolve)
                        append(" Declare ")
                        if (resolve.isPtrSafe) {
                            append("PtrSafe ")
                        }
                        bold {
                            if (resolve.function != null) {
                                append("Function ")
                            } else {
                                append("Sub ")
                            }
                        }
                        appendName(resolve)
                        resolve.lib?.let {
                            append(" Lib \"${it.stringLiteral?.value}\" ")
                        }
                        resolve.alias?.let {
                            append(" Alias \"${it.stringLiteral?.value}\" ")
                        }
                        appendArguments(resolve)
                        appendTypeInferable(resolve)

                    }
                    is VB6Module -> {
                        if (resolve.isClass()) {
                            append("Class ")
                        } else {
                            append("Module ")
                        }
                        appendName(resolve)
                    }
                    is VB6EnumerationStmt -> {
                        appendVisibility(resolve)
                        bold { append(" Enum ") }
                        appendName(resolve)
                    }
                    is VB6EnumerationConstant -> {
                        appendName(resolve)
                        // append(" = ")
                        // todo value
                    }
                    is VB6TypeStmt -> {
                        appendVisibility(resolve)
                        bold { append(" Type ") }
                        appendName(resolve)
                    }
                    is VB6TypeStmtMember -> {
                        appendName(resolve)
                        appendTypeInferable(resolve)
                    }

                    is VB6ConstStmt -> {
                        if (resolve.isModuleConst) {
                            appendVisibility(resolve)
                            append(" ")
                        }
                        bold { append("Const ") }
                        appendName(resolve)
                        appendTypeInferable(resolve)
                    }
                    is VB6VariableDeclaration -> {
                        if (resolve.isModuleVariable) {
                            appendVisibility(resolve)
                            bold { append(" Dim ") }
                            if (resolve.withEvents) {
                                append("Withevents ")
                            }
                        } else {
                            bold {
                                if (resolve.isStatic) {
                                    append("Static")
                                } else {
                                    append("Dim ")
                                }
                            }
                        }
                        appendName(resolve)
                        appendTypeInferable(resolve)
                    }
                    is VB6TypeInferable -> {
                        when (resolve) {
                            is PsiNamedElement -> appendName(resolve)
                        }
                        appendTypeInferable(resolve)
                    }
                    is VB6BaseType -> {
                        append(resolve.name)
                    }
                }
                appendFileName(resolve)
            }
        }
    }
}

private fun StringBuilder.appendName(resolve: PsiNamedElement) {
    append(resolve.name)
}

private fun StringBuilder.appendVisibility(resolve: VB6VisibilityOwner) {
    append(resolve.visibility.beautifulName)
}

private fun StringBuilder.appendArguments(resolve: VB6ArgumentOwner) {
    append("(${resolve.arguments.joinToString(", ") { it.text }})")
}

private fun StringBuilder.appendTypeInferable(resolve: VB6TypeInferable) {
    when (val inferenceResult = resolve.inferType()) {
        is InferenceResult.BaseType -> appendTypeName(inferenceResult.typeName)
        is InferenceResult.Unknown -> appendTypeName("Variant")
        is InferenceResult.UserDefinedType -> appendTypeName(inferenceResult.typeDeclaration.name)
    }
}

private fun StringBuilder.appendFileName(element: PsiElement?) {
    element?.let {
        append(" [${element.containingFile.name}]")
    }
}

private fun StringBuilder.appendTypeName(typeName: String?) {
    if (typeName != null) {
        append(" As")
        bold {
            append(" $typeName")
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