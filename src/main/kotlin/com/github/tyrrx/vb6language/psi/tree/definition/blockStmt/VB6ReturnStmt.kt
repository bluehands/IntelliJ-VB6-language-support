package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6ReturnStmt : VB6Statement {
}

class VB6ReturnStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ReturnStmt {

    object Factory : IPsiNodeFactory<VB6ReturnStmt> {
        override fun createPsiNode(node: ASTNode): VB6ReturnStmt {
            return VB6ReturnStmtImpl(node)
        }
    }
}