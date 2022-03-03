package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Argument

interface VB6ArgumentOwner {
    fun getArguments(): List<VB6Argument>
}