package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block

interface VB6BlockScopeOwner: VB6ScopeNode {
    val block: VB6Block?
}