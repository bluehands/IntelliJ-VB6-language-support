package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6ErrorStmt : VB6StatementBase {
}

class VB6ErrorStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ErrorStmt {

    object Factory : IPsiNodeFactory<VB6ErrorStmt> {
        override fun createPsiNode(node: ASTNode): VB6ErrorStmt {
            return VB6ErrorStmtImpl(node)
        }
    }
}