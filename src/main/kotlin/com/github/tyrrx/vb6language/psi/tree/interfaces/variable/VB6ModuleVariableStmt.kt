package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement

interface VB6ModuleVariableStmt : VB6Statement {
    fun getModuleVariables(): List<VB6ModuleVariableDefinition>
}