package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6BeepStmt
import com.intellij.lang.ASTNode

class VB6BeepStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6BeepStmt {

    object Factory : IPsiNodeFactory<VB6BeepStmt> {
        override fun createPsiNode(node: ASTNode): VB6BeepStmt {
            return VB6BeepStmtImpl(node)
        }
    }
}