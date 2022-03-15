package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6RaiseEventStmt : VB6StatementBase {
}

class VB6RaiseEventStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RaiseEventStmt {

    object Factory : IPsiNodeFactory<VB6RaiseEventStmt> {
        override fun createPsiNode(node: ASTNode): VB6RaiseEventStmt {
            return VB6RaiseEventStmtImpl(node)
        }
    }
}