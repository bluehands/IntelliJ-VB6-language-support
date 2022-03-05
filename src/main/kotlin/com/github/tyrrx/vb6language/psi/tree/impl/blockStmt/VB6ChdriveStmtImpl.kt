package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ChdriveStmt
import com.intellij.lang.ASTNode

class VB6ChdriveStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ChdriveStmt {

    object Factory : IPsiNodeFactory<VB6ChdriveStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdriveStmt {
            return VB6ChdriveStmtImpl(node)
        }
    }
}