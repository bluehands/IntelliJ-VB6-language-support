package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6RmdirStmt
import com.intellij.lang.ASTNode

class VB6RmdirStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6RmdirStmt {

    object Factory : IPsiNodeFactory<VB6RmdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6RmdirStmt {
            return VB6RmdirStmtImpl(node)
        }
    }
}