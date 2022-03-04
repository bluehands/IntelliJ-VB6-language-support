package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6PrintStmt
import com.intellij.lang.ASTNode

class VB6PrintStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6PrintStmt {

    object Factory : IPsiNodeFactory<VB6PrintStmt> {
        override fun createPsiNode(node: ASTNode): VB6PrintStmt {
            return VB6PrintStmtImpl(node)
        }
    }
}