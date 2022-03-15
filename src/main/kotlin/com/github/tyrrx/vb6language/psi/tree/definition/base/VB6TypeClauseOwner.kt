package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause

interface VB6TypeClauseOwner {
    fun getAsTypeClause(): VB6AsTypeClause?
}