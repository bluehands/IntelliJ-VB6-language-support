package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6LoadStmt : VB6StatementBase {
}

class VB6LoadStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LoadStmt {

    object Factory : IPsiNodeFactory<VB6LoadStmt> {
        override fun createPsiNode(node: ASTNode): VB6LoadStmt {
            return VB6LoadStmtImpl(node)
        }
    }
}