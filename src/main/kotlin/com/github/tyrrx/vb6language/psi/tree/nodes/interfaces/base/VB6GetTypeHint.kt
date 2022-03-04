package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6TypeHint
import com.intellij.psi.PsiElement

interface VB6GetTypeHint: PsiElement {
    fun getTypeHint(): VB6TypeHint?
}