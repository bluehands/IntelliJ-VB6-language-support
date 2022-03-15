package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6StopStmt : VB6StatementBase {
}

class VB6StopStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6StopStmt {

    object Factory : IPsiNodeFactory<VB6StopStmt> {
        override fun createPsiNode(node: ASTNode): VB6StopStmt {
            return VB6StopStmtImpl(node)
        }
    }
}