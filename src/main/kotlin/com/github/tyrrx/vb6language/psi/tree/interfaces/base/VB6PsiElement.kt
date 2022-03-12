package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.intellij.psi.PsiElement

interface VB6PsiElement : PsiElement {
    override fun getContext(): VB6ScopeNode?
}