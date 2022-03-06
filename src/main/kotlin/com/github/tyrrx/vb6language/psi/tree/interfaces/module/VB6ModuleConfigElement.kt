package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner

interface VB6ModuleConfigElement: VB6IdentifierOwner {
    fun getLiteral(): VB6Literal?
}