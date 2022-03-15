package com.github.tyrrx.vb6language.psi.tree.interfaces.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6iCS_S_MemberCall : PsiElement {
}

class VB6iCS_S_MemberCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_MemberCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_MemberCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_MemberCall {
            return VB6iCS_S_MemberCallImpl(node)
        }
    }
}