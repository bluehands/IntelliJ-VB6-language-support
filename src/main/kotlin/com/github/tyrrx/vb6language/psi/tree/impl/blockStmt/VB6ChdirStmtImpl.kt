package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ChdirStmt
import com.intellij.lang.ASTNode

class VB6ChdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ChdirStmt {

    object Factory : IPsiNodeFactory<VB6ChdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdirStmt {
            return VB6ChdirStmtImpl(node)
        }
    }
}