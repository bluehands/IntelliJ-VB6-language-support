package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6DateStmt : VB6StatementBase {
}

class VB6DateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DateStmt {

    object Factory : IPsiNodeFactory<VB6DateStmt> {
        override fun createPsiNode(node: ASTNode): VB6DateStmt {
            return VB6DateStmtImpl(node)
        }
    }
}