package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6VariableListStmt
import com.intellij.lang.ASTNode

class VB6VariableListStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6VariableListStmt {

    object Factory : IPsiNodeFactory<VB6VariableListStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableListStmt {
            return VB6VariableListStmtImpl(node)
        }
    }
}