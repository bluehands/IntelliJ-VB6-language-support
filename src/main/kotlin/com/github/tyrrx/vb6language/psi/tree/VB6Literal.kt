package com.github.tyrrx.vb6language.psi.tree

import com.intellij.psi.PsiElement

interface VB6Literal: PsiElement {
    fun getLiteralElement(): PsiElement
}