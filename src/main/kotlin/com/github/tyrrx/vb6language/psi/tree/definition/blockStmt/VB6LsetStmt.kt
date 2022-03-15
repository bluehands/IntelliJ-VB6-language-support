package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6LsetStmt : VB6Statement {
}

class VB6LsetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LsetStmt {

    object Factory : IPsiNodeFactory<VB6LsetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LsetStmt {
            return VB6LsetStmtImpl(node)
        }
    }
}