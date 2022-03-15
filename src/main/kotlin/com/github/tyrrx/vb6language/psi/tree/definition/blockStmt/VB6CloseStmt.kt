package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6CloseStmt : VB6StatementBase {
}

class VB6CloseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6CloseStmt {

    object Factory : IPsiNodeFactory<VB6CloseStmt> {
        override fun createPsiNode(node: ASTNode): VB6CloseStmt {
            return VB6CloseStmtImpl(node)
        }
    }
}