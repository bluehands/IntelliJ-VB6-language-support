package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6TypeClauseDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6SubscriptsDefinition

interface VB6BlockVariableDefinition :
    VB6VariableDefinition,
    VB6TypeClauseDefinition,
    VB6SubscriptsDefinition {
    fun isStatic(): Boolean
}