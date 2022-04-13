package com.github.tyrrx.vb6language.psi.tree.definition.identifier

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6AmbiguousKeyword: PsiElement {
}

class VB6AmbiguousKeywordImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AmbiguousKeyword {

    object Factory : IPsiNodeFactory<VB6AmbiguousKeyword> {
        override fun createPsiNode(node: ASTNode): VB6AmbiguousKeyword {
            return VB6AmbiguousKeywordImpl(node)
        }
    }
}