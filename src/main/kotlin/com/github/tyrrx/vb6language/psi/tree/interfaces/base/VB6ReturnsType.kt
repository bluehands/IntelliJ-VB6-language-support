package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6AsTypeClause

interface VB6ReturnsType {
    fun getReturnAsTypeClause(): VB6AsTypeClause?
    fun getReturnType(): VB6Type? // Todo non nullable and resolve type from context
}