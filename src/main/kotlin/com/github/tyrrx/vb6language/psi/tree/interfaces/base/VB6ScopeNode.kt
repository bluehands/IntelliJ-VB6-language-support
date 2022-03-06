package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6ScopeNode : ScopeNode {
    override fun resolve(element: PsiNamedElement?): VB6IdentifierOwner?
    override fun getContext(): VB6ScopeNode?
}