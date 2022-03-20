package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block

interface VB6BlockOwner : VB6PsiElement {
    val block: VB6Block?
}