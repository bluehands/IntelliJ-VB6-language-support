package com.github.tyrrx.vb6language.psi.base

interface VB6MemberReferenceOwner : VB6ReferenceOwner {
    val previousReferenceOwner: VB6ReferenceOwner?
}