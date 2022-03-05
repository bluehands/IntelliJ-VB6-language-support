package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6BlockScope: ScopeNode {
    fun getBlock(): VB6Block?
}