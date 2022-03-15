package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6SetStmt : VB6Statement {
}

class VB6SetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SetStmt {

    object Factory : IPsiNodeFactory<VB6SetStmt> {
        override fun createPsiNode(node: ASTNode): VB6SetStmt {
            return VB6SetStmtImpl(node)
        }
    }
}