package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6WidthStmt
import com.intellij.lang.ASTNode

class VB6WidthStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WidthStmt {

    object Factory : IPsiNodeFactory<VB6WidthStmt> {
        override fun createPsiNode(node: ASTNode): VB6WidthStmt {
            return VB6WidthStmtImpl(node)
        }
    }
}