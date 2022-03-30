package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class EventReference(
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
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        return referencingNamedElement.name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSoft(): Boolean {
        return false
    }
}