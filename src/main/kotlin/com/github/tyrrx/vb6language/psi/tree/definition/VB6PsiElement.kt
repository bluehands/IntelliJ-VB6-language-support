package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.scope.VB6ScopeNode
import com.intellij.psi.PsiElement

interface VB6PsiElement : PsiElement {
    override fun getContext(): VB6ScopeNode?
    override fun getFirstChild(): PsiElement?
    override fun getReference(): VB6Reference?
}