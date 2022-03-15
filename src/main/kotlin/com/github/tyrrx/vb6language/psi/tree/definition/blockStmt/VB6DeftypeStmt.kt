package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6DeftypeStmt : VB6StatementBase {
    // Todo defintiion
}

class VB6DeftypeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DeftypeStmt {

    object Factory : IPsiNodeFactory<VB6DeftypeStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeftypeStmt {
            return VB6DeftypeStmtImpl(node)
        }
    }
}