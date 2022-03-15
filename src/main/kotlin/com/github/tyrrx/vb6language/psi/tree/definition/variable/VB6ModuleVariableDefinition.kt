package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum

interface VB6ModuleVariableDefinition : VB6VariableDefinitionBase {
    fun getVisibility(): VB6VisibilityEnum
    fun withEvents(): Boolean
}