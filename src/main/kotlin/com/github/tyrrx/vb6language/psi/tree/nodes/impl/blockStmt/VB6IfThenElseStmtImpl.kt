package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6IfThenElseStmt
import com.intellij.lang.ASTNode

class VB6IfThenElseStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6IfThenElseStmt {

    object Factory : IPsiNodeFactory<VB6IfThenElseStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfThenElseStmt {
            return VB6IfThenElseStmtImpl(node)
        }
    }
}