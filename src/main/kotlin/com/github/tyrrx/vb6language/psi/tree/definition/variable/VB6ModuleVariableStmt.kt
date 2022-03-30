package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ModuleVariableStmt :
    VB6NamedElementsOwner,
    VB6StatementBase {
    val variableDefinitions: List<VB6ModuleVariable>
}

class VB6ModuleVariableStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleVariableStmt {

    object Factory : IPsiNodeFactory<VB6ModuleVariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6ModuleVariableStmt {
            return VB6ModuleVariableStmtImpl(node)
        }
    }

    override val variableDefinitions: List<VB6ModuleVariable>
        get() = findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()

    override val namedElementOwners: List<VB6NamedElementOwner>
        get() = variableDefinitions

    override val namedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?
}