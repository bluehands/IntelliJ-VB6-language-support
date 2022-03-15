package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6AsTypeClause

interface VB6TypeClauseOwner {
    fun getAsTypeClause(): VB6AsTypeClause?
}