package com.github.tyrrx.vb6language.psi.reference.impl

import com.github.tyrrx.vb6language.psi.reference.IVariableOrProcedureReference
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class VariableOrProcedureReference(private val myElement: VB6ReferenceOwner): IVariableOrProcedureReference {
    override fun getElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getRangeInElement(): TextRange {
        TODO("Not yet implemented")
    }

    override fun resolve(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }
}