package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AsTypeClause

interface VB6ReturnsType {
    fun getReturnAsTypeClause(): VB6AsTypeClause?
    fun getReturnType(): VB6Type?
}