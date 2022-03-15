package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ModuleVariableStmt : VB6StatementBase {
    val definitions: List<VB6ModuleVariableDefinition>
}

class VB6ModuleVariableStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleVariableStmt {

    object Factory : IPsiNodeFactory<VB6ModuleVariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6ModuleVariableStmt {
            return VB6ModuleVariableStmtImpl(node)
        }
    }

    override val definitions: List<VB6ModuleVariableDefinition>
        get() = findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()
}