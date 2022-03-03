package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6GetVisibilityMixin
import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6SubroutineStatement: VB6GetVisibilityMixin, ScopeNode, PsiNameIdentifierOwner {
}