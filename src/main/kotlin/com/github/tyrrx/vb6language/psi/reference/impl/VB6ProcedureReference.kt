package com.github.tyrrx.vb6language.psi.reference.impl

import com.github.tyrrx.vb6language.psi.reference.IVB6ProcedureReference
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6ProcedureReference(private val myElement: PsiNamedElement) : IVB6ProcedureReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, myElement.text.length)
    }

    override fun resolve(): PsiElement? {
        val scopeNode = myElement.context as VB6ScopeNode?
        return scopeNode?.resolve(myElement)
    }

    override fun getCanonicalText(): String {
        return element.text
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.setName(newElementName);
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val name = myElement.name
        if (element is PsiNamedElement) {
            val otherName = element.name
            return otherName == name
        }
        return false
    }

    override fun isSoft(): Boolean {
        return false
    }
}