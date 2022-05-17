package com.github.tyrrx.vb6language.psi.reference

interface VB6MemberReferenceOwner : VB6ReferenceOwner {
    val previousReferenceOwner: VB6ReferenceOwner?
}