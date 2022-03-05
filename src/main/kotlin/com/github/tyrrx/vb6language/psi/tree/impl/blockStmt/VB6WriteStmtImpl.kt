package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6WriteStmt
import com.intellij.lang.ASTNode

class VB6WriteStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WriteStmt {

    object Factory : IPsiNodeFactory<VB6WriteStmt> {
        override fun createPsiNode(node: ASTNode): VB6WriteStmt {
            return VB6WriteStmtImpl(node)
        }
    }
}