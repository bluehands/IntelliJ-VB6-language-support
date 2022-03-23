package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6BlockMembersCall : PsiElement {
}


class VB6BlockMembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6BlockMembersCall {

    object Factory : IPsiNodeFactory<VB6BlockMembersCall> {
        override fun createPsiNode(node: ASTNode): VB6BlockMembersCall {
            return VB6BlockMembersCallImpl(node)
        }
    }
}