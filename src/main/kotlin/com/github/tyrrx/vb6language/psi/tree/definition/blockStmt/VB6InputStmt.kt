package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6InputStmt : VB6Statement {
}

class VB6InputStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6InputStmt {

    object Factory : IPsiNodeFactory<VB6InputStmt> {
        override fun createPsiNode(node: ASTNode): VB6InputStmt {
            return VB6InputStmtImpl(node)
        }
    }
}