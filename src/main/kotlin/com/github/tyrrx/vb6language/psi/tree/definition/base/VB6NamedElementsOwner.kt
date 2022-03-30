package com.github.tyrrx.vb6language.psi.tree.definition.base

interface VB6NamedElementsOwner {
    val namedElementOwners: List<VB6NamedElementOwner>
    val namedElements: List<VB6NamedElement>
}