package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6ImplementsStmt : VB6Statement {
}

class VB6ImplementsStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ImplementsStmt {

    object Factory : IPsiNodeFactory<VB6ImplementsStmt> {
        override fun createPsiNode(node: ASTNode): VB6ImplementsStmt {
            return VB6ImplementsStmtImpl(node)
        }
    }
}