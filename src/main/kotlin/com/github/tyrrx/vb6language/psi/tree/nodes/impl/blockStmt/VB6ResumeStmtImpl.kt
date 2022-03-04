package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6ResumeStmt
import com.intellij.lang.ASTNode

class VB6ResumeStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ResumeStmt {

    object Factory : IPsiNodeFactory<VB6ResumeStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResumeStmt {
            return VB6ResumeStmtImpl(node)
        }
    }
}