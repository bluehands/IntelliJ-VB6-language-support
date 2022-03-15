package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6AppactivateStmt : VB6Statement {
}

class VB6AppactivateStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AppactivateStmt {

    object Factory : IPsiNodeFactory<VB6AppactivateStmt> {
        override fun createPsiNode(node: ASTNode): VB6AppactivateStmt {
            return VB6AppactivateStmtImpl(node)
        }
    }
}