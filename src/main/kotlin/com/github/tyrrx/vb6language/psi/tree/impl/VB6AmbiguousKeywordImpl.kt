package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6AmbiguousKeyword
import com.intellij.lang.ASTNode

class VB6AmbiguousKeywordImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AmbiguousKeyword {

    object Factory : IPsiNodeFactory<VB6AmbiguousKeyword> {
        override fun createPsiNode(node: ASTNode): VB6AmbiguousKeyword {
            return VB6AmbiguousKeywordImpl(node)
        }
    }
}