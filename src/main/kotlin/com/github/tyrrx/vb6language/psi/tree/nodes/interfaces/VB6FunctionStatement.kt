package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6ReturnsType
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityFromChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6FunctionStatement :
    ScopeNode,
    VB6AmbiguousIdentifierOwner,
    VB6ArgumentOwner,
    VB6ReturnsType,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin,
    VB6GetTypeHintFromChildrenMixin {

}