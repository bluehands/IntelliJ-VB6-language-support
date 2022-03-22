package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.reference.visitor.resolveInContext
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

interface VB6Reference : PsiReference {
    val myElement: VB6ReferenceOwner
    val referencingIdentifier: VB6Identifier
    val textRange: TextRange
}

class SymbolReference(
    override val myElement: VB6ReferenceOwner,
    override val referencingIdentifier: VB6Identifier,
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
                referencingIdentifier
            )
        )
    }

    override fun getCanonicalText(): String {
        return referencingIdentifier.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return referencingIdentifier.setName(newElementName)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val otherElement = when (element) {
            is VB6Identifier -> element.getOwner()
            else -> element
        }

        if (otherElement === myElement) {
            return true
        }

        val resolve = resolve()
        return otherElement === resolve
    }

    private fun compareElements(element: PsiNamedElement) =
        element.name == referencingIdentifier.name && element === resolve()

    override fun isSoft(): Boolean {
        return false
    }
}