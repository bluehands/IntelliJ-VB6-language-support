package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner

interface VB6Attribute : VB6AmbiguousIdentifierOwner {
    fun getLiterals(): Collection<VB6Literal>
}