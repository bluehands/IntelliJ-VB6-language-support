package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6BlockCall : VB6StatementBase {
}

class VB6BlockCallImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockCall {

    object Factory : IPsiNodeFactory<VB6BlockCall> {
        override fun createPsiNode(node: ASTNode): VB6BlockCall {
            return VB6BlockCallImpl(node)
        }
    }
}