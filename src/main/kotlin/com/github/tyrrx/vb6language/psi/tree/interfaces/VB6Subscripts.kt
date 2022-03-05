package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.intellij.psi.PsiElement

interface VB6Subscripts : PsiElement {
    fun getElements(): List<VB6SubscriptElement>
}