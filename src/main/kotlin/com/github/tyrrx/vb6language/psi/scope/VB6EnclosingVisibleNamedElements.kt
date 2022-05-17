package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner

interface VB6EnclosingVisibleNamedElements {
    val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
}