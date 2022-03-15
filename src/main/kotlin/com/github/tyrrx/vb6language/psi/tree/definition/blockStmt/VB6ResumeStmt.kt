package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6ResumeStmt : VB6StatementBase {
}

class VB6ResumeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ResumeStmt {

    object Factory : IPsiNodeFactory<VB6ResumeStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResumeStmt {
            return VB6ResumeStmtImpl(node)
        }
    }
}