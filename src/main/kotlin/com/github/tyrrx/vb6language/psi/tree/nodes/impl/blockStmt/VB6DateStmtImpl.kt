package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6DateStmt
import com.intellij.lang.ASTNode

class VB6DateStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DateStmt {

    object Factory : IPsiNodeFactory<VB6DateStmt> {
        override fun createPsiNode(node: ASTNode): VB6DateStmt {
            return VB6DateStmtImpl(node)
        }
    }
}