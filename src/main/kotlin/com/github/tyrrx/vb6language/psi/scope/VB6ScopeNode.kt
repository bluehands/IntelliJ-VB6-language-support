package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor

interface VB6ScopeNode : VB6PsiElement {
    fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn
    override fun getContext(): VB6ScopeNode?
}