package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement

interface VB6ModuleDeclarationsElement : VB6PsiElement {
    fun getInnerElement(): VB6PsiElement
}