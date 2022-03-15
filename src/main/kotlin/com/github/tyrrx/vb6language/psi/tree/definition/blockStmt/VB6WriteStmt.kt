package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6WriteStmt : VB6StatementBase {
}

class VB6WriteStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WriteStmt {

    object Factory : IPsiNodeFactory<VB6WriteStmt> {
        override fun createPsiNode(node: ASTNode): VB6WriteStmt {
            return VB6WriteStmtImpl(node)
        }
    }
}