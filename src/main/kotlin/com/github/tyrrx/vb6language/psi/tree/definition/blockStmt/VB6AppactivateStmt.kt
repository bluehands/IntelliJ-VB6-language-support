package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6AppactivateStmt : VB6StatementBase {
}

class VB6AppactivateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AppactivateStmt {

    object Factory : IPsiNodeFactory<VB6AppactivateStmt> {
        override fun createPsiNode(node: ASTNode): VB6AppactivateStmt {
            return VB6AppactivateStmtImpl(node)
        }
    }
}