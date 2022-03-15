package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6EndStmt : VB6StatementBase {
}

class VB6EndStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6EndStmt {

    object Factory : IPsiNodeFactory<VB6EndStmt> {
        override fun createPsiNode(node: ASTNode): VB6EndStmt {
            return VB6EndStmtImpl(node)
        }
    }
}