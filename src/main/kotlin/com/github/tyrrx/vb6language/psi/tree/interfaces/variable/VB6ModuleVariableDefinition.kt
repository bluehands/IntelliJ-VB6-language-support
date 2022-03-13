package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6VisibilityEnum

interface VB6ModuleVariableDefinition : VB6VariableDefinition {
    fun getVisibility(): VB6VisibilityEnum
    fun withEvents(): Boolean
}