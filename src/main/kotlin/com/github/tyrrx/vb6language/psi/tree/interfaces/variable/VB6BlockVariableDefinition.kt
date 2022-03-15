package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6SubscriptsDefinition

interface VB6BlockVariableDefinition :
    VB6VariableDefinition,
    VB6TypeClauseOwner,
    VB6SubscriptsDefinition {
    fun isStatic(): Boolean
}