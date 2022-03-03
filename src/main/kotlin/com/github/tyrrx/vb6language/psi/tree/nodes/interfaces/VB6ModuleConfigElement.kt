package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner

interface VB6ModuleConfigElement: VB6AmbiguousIdentifierOwner {
    fun getLiteral(): VB6Literal?
}