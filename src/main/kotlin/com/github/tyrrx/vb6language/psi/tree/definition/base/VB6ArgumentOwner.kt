package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument

interface VB6ArgumentOwner {
    fun getArguments(): List<VB6Argument>
}