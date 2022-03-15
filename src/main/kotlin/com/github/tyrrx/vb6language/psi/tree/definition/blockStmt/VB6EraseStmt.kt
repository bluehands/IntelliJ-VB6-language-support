package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6EraseStmt : VB6StatementBase {
}

class VB6EraseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6EraseStmt {

    object Factory : IPsiNodeFactory<VB6EraseStmt> {
        override fun createPsiNode(node: ASTNode): VB6EraseStmt {
            return VB6EraseStmtImpl(node)
        }
    }
}