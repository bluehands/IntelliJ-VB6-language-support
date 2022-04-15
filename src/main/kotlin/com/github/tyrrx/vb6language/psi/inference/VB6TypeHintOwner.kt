package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint
import com.intellij.psi.PsiElement

interface VB6TypeHintOwner: PsiElement {
    fun getTypeHint(): VB6TypeHint?
}