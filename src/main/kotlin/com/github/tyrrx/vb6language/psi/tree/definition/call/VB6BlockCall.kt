package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6BlockCall : VB6PsiElement {
}

class VB6BlockCallImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockCall {

    object Factory : IPsiNodeFactory<VB6BlockCall> {
        override fun createPsiNode(node: ASTNode): VB6BlockCall {
            return VB6BlockCallImpl(node)
        }
    }
}