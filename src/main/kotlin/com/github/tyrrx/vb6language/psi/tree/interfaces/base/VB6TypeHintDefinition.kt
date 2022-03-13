package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6TypeHint
import com.intellij.psi.PsiElement

interface VB6TypeHintDefinition: PsiElement {
    fun getTypeHint(): VB6TypeHint?
}