package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6LoadStmt : VB6Statement {
}

class VB6LoadStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LoadStmt {

    object Factory : IPsiNodeFactory<VB6LoadStmt> {
        override fun createPsiNode(node: ASTNode): VB6LoadStmt {
            return VB6LoadStmtImpl(node)
        }
    }
}