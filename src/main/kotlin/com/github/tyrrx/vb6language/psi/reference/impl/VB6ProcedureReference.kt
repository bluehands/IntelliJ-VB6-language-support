package com.github.tyrrx.vb6language.psi.reference.impl

import com.github.tyrrx.vb6language.psi.reference.IVB6ProcedureReference
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PropertyStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6SubroutineStatement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

class VB6ProcedureReference(private val myElement: VB6ReferenceOwner) : IVB6ProcedureReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        val length = myElement.getIdentifier().textLength
        val start = myElement.textLength - length
        return TextRange(start, length + start)
    }

    override fun resolve(): PsiElement? {
        val scopeNode = myElement.context as VB6ScopeNode?
        return scopeNode?.resolve(myElement)
    }

    override fun getCanonicalText(): String {
        return myElement.getIdentifier().name ?: ""
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.getIdentifier().setName(newElementName);
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        return isFunction(element)
    }

    private fun isFunction(element: PsiElement) = when(element) {
        is VB6SubroutineStatement -> true
        is VB6FunctionStatement -> true
        is VB6PropertyStatement -> true
        else -> false
    }

    private fun compareNames(element: VB6IdentifierOwner) =
        element.name == myElement.getIdentifier().name

    override fun isSoft(): Boolean {
        return false
    }
}