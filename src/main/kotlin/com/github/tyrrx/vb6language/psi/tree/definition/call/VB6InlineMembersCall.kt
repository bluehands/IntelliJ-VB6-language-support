package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6InlineMembersCall : PsiElement {
}

class VB6InlineMembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineMembersCall {

    object Factory : IPsiNodeFactory<VB6InlineMembersCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineMembersCall {
            return VB6InlineMembersCallImpl(node)
        }
    }
}