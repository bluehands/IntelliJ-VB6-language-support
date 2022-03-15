package com.github.tyrrx.vb6language.psi.tree.interfaces.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ModuleVariableStmt : VB6Statement {
    fun getModuleVariables(): List<VB6ModuleVariableDefinition>
}

class VB6ModuleVariableStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleVariableStmt {

    object Factory : IPsiNodeFactory<VB6ModuleVariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6ModuleVariableStmt {
            return VB6ModuleVariableStmtImpl(node)
        }
    }

    override fun getModuleVariables(): List<VB6ModuleVariableDefinition> {
        return findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()
    }
}