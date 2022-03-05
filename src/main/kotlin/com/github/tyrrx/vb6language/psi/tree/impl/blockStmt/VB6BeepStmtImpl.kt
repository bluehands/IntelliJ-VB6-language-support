package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6BeepStmt
import com.intellij.lang.ASTNode

class VB6BeepStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BeepStmt {

    object Factory : IPsiNodeFactory<VB6BeepStmt> {
        override fun createPsiNode(node: ASTNode): VB6BeepStmt {
            return VB6BeepStmtImpl(node)
        }
    }
}