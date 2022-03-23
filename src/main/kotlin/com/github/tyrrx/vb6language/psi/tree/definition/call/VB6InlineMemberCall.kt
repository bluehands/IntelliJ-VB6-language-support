package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6InlineMemberCall : PsiElement {
}

class VB6InlineMemberCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineMemberCall {

    object Factory : IPsiNodeFactory<VB6InlineMemberCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineMemberCall {
            return VB6InlineMemberCallImpl(node)
        }
    }
}