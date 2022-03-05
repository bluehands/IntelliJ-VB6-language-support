package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6LineInputStmt
import com.intellij.lang.ASTNode

class VB6LineInputStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LineInputStmt {

    object Factory : IPsiNodeFactory<VB6LineInputStmt> {
        override fun createPsiNode(node: ASTNode): VB6LineInputStmt {
            return VB6LineInputStmtImpl(node)
        }
    }
}