package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner

interface VB6Attribute : VB6IdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}