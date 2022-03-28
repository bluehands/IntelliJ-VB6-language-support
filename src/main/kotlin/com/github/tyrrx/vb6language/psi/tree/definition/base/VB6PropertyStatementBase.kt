package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.mixins.VB6VisibilityOwnerMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin

interface VB6PropertyStatementBase :
    VB6BlockScopeOwner,
    VB6IdentifierOwner,
    VB6ArgumentOwner,
    VB6VisibilityOwnerMixin,
    VB6IsStaticInChildrenMixin {
}