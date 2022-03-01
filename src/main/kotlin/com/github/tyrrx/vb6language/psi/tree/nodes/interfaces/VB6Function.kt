package com.github.tyrrx.vb6language.psi.tree.nodes.interfaces

import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6IsStaticMixin
import com.github.tyrrx.vb6language.psi.tree.nodes.mixins.VB6VisibilityMixin
import com.intellij.psi.PsiNameIdentifierOwner
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6Function : VB6VisibilityMixin, VB6IsStaticMixin, ScopeNode, PsiNameIdentifierOwner {

}