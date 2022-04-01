package com.github.tyrrx.vb6language.psi.tree.definition.base

interface VB6EnclosingVisibleNamedElements {
    val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
    val outsideVisibleNamedElements: List<VB6NamedElement>
}