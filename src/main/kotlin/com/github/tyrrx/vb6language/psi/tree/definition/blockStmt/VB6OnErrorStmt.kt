package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6OnErrorStmt : VB6StatementBase {
}

class VB6OnErrorStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OnErrorStmt {

    object Factory : IPsiNodeFactory<VB6OnErrorStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnErrorStmt {
            return VB6OnErrorStmtImpl(node)
        }
    }
}