package com.github.tyrrx.vb6language.psi.tree.definition.variable


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6VariableStmt : VB6StatementBase, VB6EnclosingVisibleNamedElements {
    val variables: List<VB6BlockVariable>
}

class VB6VariableStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6VariableStmt {

    object Factory : IPsiNodeFactory<VB6VariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableStmt {
            return VB6VariableStmtImpl(node)
        }
    }

    override val variables: List<VB6BlockVariable>
        get() = findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()

    override val visibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = variables

    override val visibleNamedElements: List<VB6NamedElement>
        get() = emptyList()
}