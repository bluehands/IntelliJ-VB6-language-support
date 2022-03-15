package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor

interface VB6ScopeNode : VB6PsiElement {
    fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner?
    override fun getContext(): VB6ScopeNode?
}