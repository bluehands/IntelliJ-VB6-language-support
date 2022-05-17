package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LetStmt
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForEachStmt
import com.github.tyrrx.vb6language.psi.tree.definition.loops.VB6ForNextStmt
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.psi.PsiElement

/**
 * Implements the [DocumentationProvider] interface
 */

class VB6DocumentationProvider : AbstractDocumentationProvider() {

    override fun getQuickNavigateInfo(hoveredElement: PsiElement?, elementUnderTheCaret: PsiElement?): String? {
        return when (elementUnderTheCaret) {
            is VB6ReferenceOwner -> quickNavigationInfoFor(elementUnderTheCaret.reference?.resolve())
            else -> when (hoveredElement) {
                is VB6Identifier -> {
                    if (hoveredElement.referenceOwner != null
                            && hoveredElement.namedElementOwner !is VB6LetStmt
                            && hoveredElement.namedElementOwner !is VB6ForEachStmt
                            && hoveredElement.namedElementOwner !is VB6ForNextStmt
                            && hoveredElement.namedElementOwner !is VB6AttributeStmt) {
                        val element = hoveredElement.referenceOwner?.reference?.resolve()
                        element?.let {
                            return quickNavigationInfoFor(it)
                        }
                        return "No definition found"
                    }
                    return quickNavigationInfoFor(hoveredElement.namedElementOwner)
                }
                is VB6BaseType -> {
                    hoveredElement.name
                }
                else -> quickNavigationInfoFor(hoveredElement)
            }
        }
    }


}

fun quickNavigationInfoFor(element: PsiElement?): String? {
    return when (element) {
        is VB6NamedElementOwner -> {
            buildString {
                append(element.accept(QuickNavigationInfoRendererForNamedElementOwners()))
                appendFileName(element)
            }
        }
        else -> "Not yet implemented"
    }
}
