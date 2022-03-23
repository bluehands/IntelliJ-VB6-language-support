package com.github.tyrrx.vb6language.psi.tree.definition.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6InlineCall : VB6StatementBase {

}

class VB6InlineCallImpl(node: ASTNode) : VB6PsiNode(node),
    VB6InlineCall {

    object Factory : IPsiNodeFactory<VB6InlineCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineCall {
            return VB6InlineCallImpl(node)
        }
    }
}