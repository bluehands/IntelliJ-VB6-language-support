package com.github.tyrrx.vb6language.psi.tree.impl.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6ImplicitCallStmt_InBlock
import com.intellij.lang.ASTNode

class VB6ImplicitCallStmt_InBlockImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplicitCallStmt_InBlock {

    object Factory : IPsiNodeFactory<VB6ImplicitCallStmt_InBlock> {
        override fun createPsiNode(node: ASTNode): VB6ImplicitCallStmt_InBlock {
            return VB6ImplicitCallStmt_InBlockImpl(node)
        }
    }
}