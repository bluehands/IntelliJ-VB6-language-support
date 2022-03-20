package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor

interface VB6ScopeNode : VB6PsiElement {
    fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn
    override fun getContext(): VB6ScopeNode?
}