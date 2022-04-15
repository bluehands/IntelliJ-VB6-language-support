package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6TypeHint: VB6PsiElement {
    //Todo add members
}

class VB6TypeHintImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeHint {

    object Factory : IPsiNodeFactory<VB6TypeHint> {
        override fun createPsiNode(node: ASTNode): VB6TypeHint {
            return VB6TypeHintImpl(node)
        }
    }
}