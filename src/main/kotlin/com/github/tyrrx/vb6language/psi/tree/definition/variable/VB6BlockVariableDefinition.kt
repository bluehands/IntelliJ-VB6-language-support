package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6SubscriptsOwner

interface VB6BlockVariableDefinition :
    VB6VariableDefinitionBase,
    VB6TypeClauseOwner,
    VB6SubscriptsOwner {
    fun isStatic(): Boolean
}