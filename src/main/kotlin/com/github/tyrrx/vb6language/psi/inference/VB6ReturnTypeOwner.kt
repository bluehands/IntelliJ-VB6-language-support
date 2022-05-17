package com.github.tyrrx.vb6language.psi.inference

import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeElement

interface VB6ReturnTypeOwner {
    fun getReturnAsTypeClause(): VB6AsTypeClause?
    fun getReturnType(): VB6TypeElement? // Todo non nullable and resolve type from context
}