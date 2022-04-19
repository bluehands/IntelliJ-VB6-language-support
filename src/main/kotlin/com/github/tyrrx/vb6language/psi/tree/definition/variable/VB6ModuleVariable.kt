package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner

interface VB6ModuleVariable : VB6VariableBase, VB6VisibilityOwner {
    fun withEvents(): Boolean
}