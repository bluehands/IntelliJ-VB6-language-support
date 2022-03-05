package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner

interface VB6Attribute : VB6AmbiguousIdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}