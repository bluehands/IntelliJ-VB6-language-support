package com.github.tyrrx.vb6language.psi.tree.impl.variable


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6BlockVariableDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6VariableListStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6VariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

class VB6VariableStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6VariableStmt {

    object Factory : IPsiNodeFactory<VB6VariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableStmt {
            return VB6VariableStmtImpl(node)
        }
    }

    override fun getVariables(): List<VB6BlockVariableDefinition> {
        return findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()
    }
}