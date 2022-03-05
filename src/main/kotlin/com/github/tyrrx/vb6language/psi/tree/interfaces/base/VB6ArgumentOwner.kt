package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Argument

interface VB6ArgumentOwner {
    fun getArguments(): List<VB6Argument>
}