package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6SubscriptsOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeClauseOwner

interface VB6BlockVariable :
    VB6VariableBase,
    VB6TypeClauseOwner,
    VB6SubscriptsOwner {
    fun isStatic(): Boolean
}