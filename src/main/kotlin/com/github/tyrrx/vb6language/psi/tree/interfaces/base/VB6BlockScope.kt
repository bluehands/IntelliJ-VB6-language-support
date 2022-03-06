package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block

interface VB6BlockScope: VB6ScopeNode {
    fun getBlock(): VB6Block?
}