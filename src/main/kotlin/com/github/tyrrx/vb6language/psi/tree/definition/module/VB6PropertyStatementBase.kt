package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6BlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6VisibilityOwnerMixin

interface VB6PropertyStatementBase :
    VB6EnclosingVisibleNamedElements,
    VB6BlockScopeOwner,
    VB6NamedElementOwner,
    VB6ArgumentOwner,
    VB6VisibilityOwnerMixin,
    VB6IsStaticInChildrenMixin {
}