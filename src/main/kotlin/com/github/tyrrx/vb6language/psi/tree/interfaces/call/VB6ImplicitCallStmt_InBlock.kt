package com.github.tyrrx.vb6language.psi.tree.interfaces.call


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6ImplicitCallStmt_InBlock : VB6Statement {
}

class VB6ImplicitCallStmt_InBlockImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplicitCallStmt_InBlock {

    object Factory : IPsiNodeFactory<VB6ImplicitCallStmt_InBlock> {
        override fun createPsiNode(node: ASTNode): VB6ImplicitCallStmt_InBlock {
            return VB6ImplicitCallStmt_InBlockImpl(node)
        }
    }
}