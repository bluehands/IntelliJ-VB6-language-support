package com.github.tyrrx.vb6language.psi.tree.definition.base

interface VB6MemberReferenceOwner : VB6ReferenceOwner {
    val previousReferenceOwner: VB6ReferenceOwner?
}