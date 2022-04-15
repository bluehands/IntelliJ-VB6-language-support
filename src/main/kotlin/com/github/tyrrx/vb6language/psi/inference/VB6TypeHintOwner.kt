package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeHint

interface VB6TypeHintOwner: VB6PsiElement {
    fun getTypeHint(): VB6TypeHint?
}