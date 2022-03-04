package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6FilecopyStmt
import com.intellij.lang.ASTNode

class VB6FilecopyStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6FilecopyStmt {

    object Factory : IPsiNodeFactory<VB6FilecopyStmt> {
        override fun createPsiNode(node: ASTNode): VB6FilecopyStmt {
            return VB6FilecopyStmtImpl(node)
        }
    }
}