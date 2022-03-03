package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticInChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6PropertyStatement :
    ScopeNode,
    VB6AmbiguousIdentifierOwner,
    VB6ArgumentOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin {
}