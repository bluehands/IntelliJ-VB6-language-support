package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6GoToStmt : VB6Statement {
}


class VB6GoToStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6GoToStmt {

    object Factory : IPsiNodeFactory<VB6GoToStmt> {
        override fun createPsiNode(node: ASTNode): VB6GoToStmt {
            return VB6GoToStmtImpl(node)
        }
    }
}