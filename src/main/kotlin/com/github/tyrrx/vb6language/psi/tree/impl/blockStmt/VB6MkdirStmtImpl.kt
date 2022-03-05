package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6MkdirStmt
import com.intellij.lang.ASTNode

class VB6MkdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MkdirStmt {

    object Factory : IPsiNodeFactory<VB6MkdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6MkdirStmt {
            return VB6MkdirStmtImpl(node)
        }
    }
}