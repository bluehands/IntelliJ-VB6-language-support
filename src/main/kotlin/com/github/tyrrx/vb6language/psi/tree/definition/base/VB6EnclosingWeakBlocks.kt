package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block

interface VB6EnclosingWeakBlocks : VB6PsiElement {
    val enclosingBlocks: List<VB6Block>
}