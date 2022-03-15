package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6GoSubStmt : VB6StatementBase {
}

class VB6GoSubStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6GoSubStmt {

    object Factory : IPsiNodeFactory<VB6GoSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6GoSubStmt {
            return VB6GoSubStmtImpl(node)
        }
    }
}