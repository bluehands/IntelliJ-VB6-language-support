package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.intellij.psi.PsiElement

interface VB6PsiElement : PsiElement {
    override fun getContext(): VB6ScopeNode?
    override fun getFirstChild(): PsiElement?
    override fun getReference(): VB6Reference?
}