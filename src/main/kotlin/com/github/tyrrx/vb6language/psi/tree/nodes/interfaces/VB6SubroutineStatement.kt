package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticMixin
import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6SubroutineStatement :
    ScopeNode,
    PsiNameIdentifierOwner,
    VB6GetVisibilityMixin,
    VB6IsStaticMixin {
}