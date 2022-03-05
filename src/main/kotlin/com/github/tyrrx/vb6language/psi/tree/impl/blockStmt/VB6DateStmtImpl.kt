package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6DateStmt
import com.intellij.lang.ASTNode

class VB6DateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DateStmt {

    object Factory : IPsiNodeFactory<VB6DateStmt> {
        override fun createPsiNode(node: ASTNode): VB6DateStmt {
            return VB6DateStmtImpl(node)
        }
    }
}