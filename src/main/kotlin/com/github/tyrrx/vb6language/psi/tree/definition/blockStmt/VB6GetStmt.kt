package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6GetStmt : VB6Statement {
}

class VB6GetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6GetStmt {

    object Factory : IPsiNodeFactory<VB6GetStmt> {
        override fun createPsiNode(node: ASTNode): VB6GetStmt {
            return VB6GetStmtImpl(node)
        }
    }
}