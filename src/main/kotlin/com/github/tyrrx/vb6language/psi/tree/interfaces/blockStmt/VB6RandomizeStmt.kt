package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6RandomizeStmt : VB6Statement {
}

class VB6RandomizeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RandomizeStmt {

    object Factory : IPsiNodeFactory<VB6RandomizeStmt> {
        override fun createPsiNode(node: ASTNode): VB6RandomizeStmt {
            return VB6RandomizeStmtImpl(node)
        }
    }
}