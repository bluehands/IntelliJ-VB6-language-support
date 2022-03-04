package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6AttributeStmt
import com.intellij.lang.ASTNode

class VB6AttributeStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6AttributeStmt {

    object Factory : IPsiNodeFactory<VB6AttributeStmt> {
        override fun createPsiNode(node: ASTNode): VB6AttributeStmt {
            return VB6AttributeStmtImpl(node)
        }
    }
}