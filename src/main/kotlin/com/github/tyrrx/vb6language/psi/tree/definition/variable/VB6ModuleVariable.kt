package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum

interface VB6ModuleVariable : VB6VariableBase {
    fun getVisibility(): VB6VisibilityEnum
    fun withEvents(): Boolean
}