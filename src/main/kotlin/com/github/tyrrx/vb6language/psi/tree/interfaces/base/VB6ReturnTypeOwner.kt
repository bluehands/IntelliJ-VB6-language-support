package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6TypeBase

interface VB6ReturnTypeOwner {
    fun getReturnAsTypeClause(): VB6AsTypeClause?
    fun getReturnType(): VB6TypeBase? // Todo non nullable and resolve type from context
}