package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block

interface VB6EnclosingTransparentBlocks : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val enclosingBlocks: List<VB6Block>
}