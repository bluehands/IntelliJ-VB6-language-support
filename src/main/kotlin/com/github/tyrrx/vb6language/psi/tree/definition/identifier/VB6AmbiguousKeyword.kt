package com.github.tyrrx.vb6language.psi.tree.definition.identifier

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6AmbiguousKeyword: VB6PsiElement {
}

class VB6AmbiguousKeywordImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AmbiguousKeyword {

    object Factory : IPsiNodeFactory<VB6AmbiguousKeyword> {
        override fun createPsiNode(node: ASTNode): VB6AmbiguousKeyword {
            return VB6AmbiguousKeywordImpl(node)
        }
    }
}