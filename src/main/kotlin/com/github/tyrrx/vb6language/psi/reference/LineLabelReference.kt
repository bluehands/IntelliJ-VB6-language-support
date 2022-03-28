package com.github.tyrrx.vb6language.psi.reference

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class LineLabelReference(
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
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun isSoft(): Boolean {
        return false
    }
}