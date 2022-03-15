package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6PutStmt : VB6Statement {
}

class VB6PutStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PutStmt {

    object Factory : IPsiNodeFactory<VB6PutStmt> {
        override fun createPsiNode(node: ASTNode): VB6PutStmt {
            return VB6PutStmtImpl(node)
        }
    }
}