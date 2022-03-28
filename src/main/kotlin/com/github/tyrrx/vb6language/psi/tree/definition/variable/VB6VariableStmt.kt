package com.github.tyrrx.vb6language.psi.tree.definition.variable


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6VariableBase :
    VB6IdentifierOwner,
    VB6TypeClauseOwner,
    VB6SubscriptsOwner,
    VB6TypeHintMixin {
    fun isArray(): Boolean // not valid in module with events https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
}

interface VB6ModuleVariable : VB6VariableBase {
    fun getVisibility(): VB6VisibilityEnum
    fun withEvents(): Boolean
}

interface VB6BlockVariable :
    VB6VariableBase,
    VB6TypeClauseOwner,
    VB6SubscriptsOwner {
    fun isStatic(): Boolean
}

interface VB6VariableStmt : VB6StatementBase {
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
}