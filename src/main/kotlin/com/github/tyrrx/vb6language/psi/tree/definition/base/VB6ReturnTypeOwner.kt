package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6Type

interface VB6ReturnTypeOwner {
    fun getReturnAsTypeClause(): VB6AsTypeClause?
    fun getReturnType(): VB6Type? // Todo non nullable and resolve type from context
}