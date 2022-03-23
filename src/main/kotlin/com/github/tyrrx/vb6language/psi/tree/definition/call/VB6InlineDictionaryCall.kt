package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6InlineDictionaryCall : PsiElement {
}

class VB6InlineDictionaryCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineDictionaryCall {

    object Factory : IPsiNodeFactory<VB6InlineDictionaryCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineDictionaryCall {
            return VB6InlineDictionaryCallImpl(node)
        }
    }
}