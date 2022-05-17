package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6InlineDictionaryCall : VB6PsiElement {
}

class VB6InlineDictionaryCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineDictionaryCall {

    object Factory : IPsiNodeFactory<VB6InlineDictionaryCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineDictionaryCall {
            return VB6InlineDictionaryCallImpl(node)
        }
    }
}