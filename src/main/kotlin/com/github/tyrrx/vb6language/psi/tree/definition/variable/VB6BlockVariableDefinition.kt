package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6SubscriptsDefinition

interface VB6BlockVariableDefinition :
    VB6VariableDefinition,
    VB6TypeClauseOwner,
    VB6SubscriptsDefinition {
    fun isStatic(): Boolean
}