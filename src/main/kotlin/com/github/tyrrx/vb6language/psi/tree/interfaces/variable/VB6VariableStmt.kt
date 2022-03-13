package com.github.tyrrx.vb6language.psi.tree.interfaces.variable


import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement

interface VB6VariableStmt : VB6Statement {
    fun getVariables() : List<VB6BlockVariableDefinition>
}