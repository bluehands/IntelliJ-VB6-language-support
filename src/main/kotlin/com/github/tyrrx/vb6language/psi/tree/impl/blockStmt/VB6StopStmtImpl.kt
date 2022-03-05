package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6StopStmt
import com.intellij.lang.ASTNode

class VB6StopStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6StopStmt {

    object Factory : IPsiNodeFactory<VB6StopStmt> {
        override fun createPsiNode(node: ASTNode): VB6StopStmt {
            return VB6StopStmtImpl(node)
        }
    }
}