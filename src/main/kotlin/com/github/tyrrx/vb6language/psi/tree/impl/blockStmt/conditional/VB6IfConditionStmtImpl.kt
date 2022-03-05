package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfConditionStmt
import com.intellij.lang.ASTNode

class VB6IfConditionStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfConditionStmt {

    object Factory : IPsiNodeFactory<VB6IfConditionStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfConditionStmt {
            return VB6IfConditionStmtImpl(node)
        }
    }
}