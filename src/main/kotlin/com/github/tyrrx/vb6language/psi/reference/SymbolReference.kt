package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.reference.visitor.resolveInContext
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

/**
 * Can reference:
 *      declare
 *      enumeration todo?
 *      const
 *      variable
 *      function
 *      sub
 *      property (get, let, set)
 */
class SymbolReference(
    override val myElement: VB6ReferenceOwner,
    override val referencingNamedElement: VB6NamedElement,
    override val textRange: TextRange
) : VB6Reference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        return textRange
    }

    override fun resolve(): PsiElement? {
        return myElement.resolveInContext(
            SymbolResolveVisitor(
                myElement,
                referencingNamedElement
            )
        )
    }

    override fun getCanonicalText(): String {
        return referencingNamedElement.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return referencingNamedElement.setName(newElementName)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val otherElement = when (element) {
            is VB6NamedElement -> element.namedElementOwner
            else -> element
        }

        if (otherElement === myElement) {
            return true
        }

        val resolve = resolve()
        return otherElement === resolve
    }

    private fun compareElements(element: com.intellij.psi.PsiNamedElement) =
        element.name == referencingNamedElement.name && element === resolve()

    override fun isSoft(): Boolean {
        return false
    }
}