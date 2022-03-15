package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6TimeStmt : VB6StatementBase {
}

class VB6TimeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6TimeStmt {

    object Factory : IPsiNodeFactory<VB6TimeStmt> {
        override fun createPsiNode(node: ASTNode): VB6TimeStmt {
            return VB6TimeStmtImpl(node)
        }
    }
}