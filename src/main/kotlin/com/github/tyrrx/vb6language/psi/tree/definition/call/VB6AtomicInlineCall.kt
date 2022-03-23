package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6AtomicInlineCall : VB6PsiElement {
}

class VB6AtomicInlineCallImpl(node: ASTNode) : VB6PsiNode(node), VB6AtomicInlineCall {
    object Factory : IPsiNodeFactory<VB6AtomicInlineCall> {
        override fun createPsiNode(node: ASTNode): VB6AtomicInlineCall {
            return VB6AtomicInlineCallImpl(node)
        }
    }
}