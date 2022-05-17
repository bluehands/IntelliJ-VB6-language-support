package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument

interface VB6ArgumentOwner {
    val arguments: List<VB6Argument>
}