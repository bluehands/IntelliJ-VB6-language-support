package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6FilecopyStmt : VB6StatementBase {
}

class VB6FilecopyStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FilecopyStmt {

    object Factory : IPsiNodeFactory<VB6FilecopyStmt> {
        override fun createPsiNode(node: ASTNode): VB6FilecopyStmt {
            return VB6FilecopyStmtImpl(node)
        }
    }
}