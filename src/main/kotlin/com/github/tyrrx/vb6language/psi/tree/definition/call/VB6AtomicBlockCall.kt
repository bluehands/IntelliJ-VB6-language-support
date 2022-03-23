package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6AtomicBlockCall : PsiElement {
}

class VB6AtomicBlockCallImpl(node: ASTNode) : VB6PsiNode(node), VB6AtomicBlockCall {

    object Factory : IPsiNodeFactory<VB6AtomicBlockCall> {
        override fun createPsiNode(node: ASTNode): VB6AtomicBlockCall {
            return VB6AtomicBlockCallImpl(node)
        }
    }
}