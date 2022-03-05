package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6VariableStmt
import com.intellij.lang.ASTNode

class VB6VariableStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6VariableStmt {

    object Factory : IPsiNodeFactory<VB6VariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableStmt {
            return VB6VariableStmtImpl(node)
        }
    }
}