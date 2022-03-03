package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticInChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6SubroutineStatement :
    ScopeNode,
    VB6AmbiguousIdentifierOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin {
}