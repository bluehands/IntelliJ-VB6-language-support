package com.github.tyrrx.vb6language.psi.reference.impl

import com.github.tyrrx.vb6language.psi.reference.IArrayOrProcedureReference
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ArrayOrProcedureReference(private val myElement: VB6ReferenceOwner): IArrayOrProcedureReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        val length = myElement.getIdentifier().textLength
        val start = myElement.textLength - length
        return TextRange(start, length + start)
    }

    override fun resolve(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        return myElement.getIdentifier().name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.getIdentifier().setName(newElementName)
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