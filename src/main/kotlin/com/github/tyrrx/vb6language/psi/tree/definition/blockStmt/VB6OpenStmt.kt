package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6OpenStmt : VB6StatementBase {
}

class VB6OpenStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OpenStmt {

    object Factory : IPsiNodeFactory<VB6OpenStmt> {
        override fun createPsiNode(node: ASTNode): VB6OpenStmt {
            return VB6OpenStmtImpl(node)
        }
    }
}