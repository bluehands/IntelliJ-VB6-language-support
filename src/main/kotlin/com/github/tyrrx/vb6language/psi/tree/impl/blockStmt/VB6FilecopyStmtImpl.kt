package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6FilecopyStmt
import com.intellij.lang.ASTNode

class VB6FilecopyStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FilecopyStmt {

    object Factory : IPsiNodeFactory<VB6FilecopyStmt> {
        override fun createPsiNode(node: ASTNode): VB6FilecopyStmt {
            return VB6FilecopyStmtImpl(node)
        }
    }
}