package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6SavepictureStmt : VB6Statement {
}

class VB6SavepictureStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SavepictureStmt {

    object Factory : IPsiNodeFactory<VB6SavepictureStmt> {
        override fun createPsiNode(node: ASTNode): VB6SavepictureStmt {
            return VB6SavepictureStmtImpl(node)
        }
    }
}