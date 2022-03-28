package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum

interface VB6VisibilityOwner: VB6IdentifierOwner {
    val visibility: VB6VisibilityEnum
}