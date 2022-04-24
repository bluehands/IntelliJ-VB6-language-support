package com.github.tyrrx.vb6language.documentation

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
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
                is VB6Identifier -> quickNavigationInfoFor(hoveredElement.namedElementOwner)
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
        is VB6BaseType -> {
            element.name
        }
        else -> "Not yet implemented"
    }
}
