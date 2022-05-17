package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor

fun <TReturn> VB6PsiElement.contextAccept(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn? {
    return this.context?.accept(resolveVisitor)
}

fun <TReturn> VB6PsiElement.contextAcceptOrElse(resolveVisitor: ScopeNodeVisitor<TReturn>, elseCase: TReturn): TReturn {
    return this.context?.accept(resolveVisitor) ?: elseCase
}