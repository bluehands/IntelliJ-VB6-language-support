package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner

interface VB6ModuleConfigElement: VB6AmbiguousIdentifierOwner {
    fun getLiteral(): VB6Literal?
}