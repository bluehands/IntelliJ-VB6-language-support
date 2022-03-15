package com.github.tyrrx.vb6language.psi.tree.definition.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6IfThenElseStmt : VB6Statement {
}

class VB6IfThenElseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfThenElseStmt {

    object Factory : IPsiNodeFactory<VB6IfThenElseStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfThenElseStmt {
            return VB6IfThenElseStmtImpl(node)
        }
    }
}