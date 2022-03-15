package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.intellij.psi.PsiElement

interface VB6PsiElement : PsiElement {
    override fun getContext(): VB6ScopeNode?
}