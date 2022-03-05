package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6SetattrStmt
import com.intellij.lang.ASTNode

class VB6SetattrStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SetattrStmt {

    object Factory : IPsiNodeFactory<VB6SetattrStmt> {
        override fun createPsiNode(node: ASTNode): VB6SetattrStmt {
            return VB6SetattrStmtImpl(node)
        }
    }
}