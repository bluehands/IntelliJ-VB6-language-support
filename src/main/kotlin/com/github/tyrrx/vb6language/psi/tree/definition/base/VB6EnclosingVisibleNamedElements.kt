package com.github.tyrrx.vb6language.psi.tree.definition.base

interface VB6EnclosingVisibleNamedElements {
    val visibleNamedElementOwners: List<VB6NamedElementOwner>
    val visibleNamedElements: List<VB6NamedElement>
}