package com.github.tyrrx.vb6language.psi.tree.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6PropertyStatement :
    VB6BlockScope,
    VB6AmbiguousIdentifierOwner,
    VB6ArgumentOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin {
}