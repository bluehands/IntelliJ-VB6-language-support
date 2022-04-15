package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.scope.VB6BlockScopeOwner
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6VisibilityOwnerMixin

interface VB6PropertyStatementBase :
    VB6EnclosingVisibleNamedElements,
        VB6BlockScopeOwner,
        VB6NamedElementOwner,
        VB6ArgumentOwner,
        VB6VisibilityOwnerMixin,
        VB6IsStaticInChildrenMixin {
}