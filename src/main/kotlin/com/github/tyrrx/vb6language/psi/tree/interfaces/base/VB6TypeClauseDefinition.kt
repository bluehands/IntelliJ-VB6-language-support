package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6AsTypeClause

interface VB6TypeClauseDefinition {
    fun getAsTypeClause(): VB6AsTypeClause?
}