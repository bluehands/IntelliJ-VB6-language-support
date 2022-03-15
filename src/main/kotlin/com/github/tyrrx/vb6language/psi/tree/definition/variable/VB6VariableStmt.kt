package com.github.tyrrx.vb6language.psi.tree.definition.variable


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6VariableStmt : VB6Statement {
    fun getVariables() : List<VB6BlockVariableDefinition>
}

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