package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base

import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6PropertyStatement :
    ScopeNode,
    VB6AmbiguousIdentifierOwner,
    VB6GetVisibilityMixin,
    VB6IsStaticMixin {
}