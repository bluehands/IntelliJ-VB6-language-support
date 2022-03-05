package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6SeekStmt
import com.intellij.lang.ASTNode

class VB6SeekStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SeekStmt {

    object Factory : IPsiNodeFactory<VB6SeekStmt> {
        override fun createPsiNode(node: ASTNode): VB6SeekStmt {
            return VB6SeekStmtImpl(node)
        }
    }
}