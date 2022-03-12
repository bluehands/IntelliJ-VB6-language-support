package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6ScopeNode : VB6PsiElement {
    fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner?
    override fun getContext(): VB6ScopeNode?
}