package com.github.tyrrx.vb6language.psi.reference.references

import com.github.tyrrx.vb6language.psi.reference.visitor.TypeResolveVisitor
import com.github.tyrrx.vb6language.psi.reference.visitor.acceptToContext
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class TypeReference(
        override val myReferenceOwner: VB6ReferenceOwner,
        override val referencingNamedElement: VB6NamedElement,
        override val textRange: TextRange
) : VB6Reference {
    override fun getElement(): PsiElement {
        return myReferenceOwner
    }

    override fun getRangeInElement(): TextRange {
        return textRange
    }

    override fun resolve(): PsiElement? {
        val resolveInContext = myReferenceOwner.acceptToContext(
            TypeResolveVisitor(
                myReferenceOwner,
                referencingNamedElement
            )
        )
        return resolveInContext
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

        val resolve = resolve()
        return otherElement === resolve
    }

    override fun isSoft(): Boolean {
        return false
    }
}