package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6ElseBlockStmt
import com.intellij.lang.ASTNode

class VB6ElseBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ElseBlockStmt {

    object Factory : IPsiNodeFactory<VB6ElseBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6ElseBlockStmt {
            return VB6ElseBlockStmtImpl(node)
        }
    }
}