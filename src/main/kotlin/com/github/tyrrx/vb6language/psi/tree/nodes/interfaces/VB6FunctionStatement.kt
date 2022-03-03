package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetTypeHintInDirectChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityMixin
import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6FunctionStatement :
    ScopeNode,
    VB6AmbiguousIdentifierOwner,
    VB6ArgumentOwner,
    VB6GetVisibilityMixin,
    VB6IsStaticMixin,
    VB6GetTypeHintInDirectChildrenMixin {

}