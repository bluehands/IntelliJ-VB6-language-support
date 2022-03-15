package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin

interface VB6PropertyStatementBase :
    VB6BlockScope,
    VB6IdentifierOwner,
    VB6ArgumentOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin {
}