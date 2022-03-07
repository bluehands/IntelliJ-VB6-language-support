package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6ScopeNode : PsiElement{
    fun resolve(element: VB6ReferenceOwner?): VB6IdentifierOwner?
    override fun getContext(): VB6ScopeNode?
}