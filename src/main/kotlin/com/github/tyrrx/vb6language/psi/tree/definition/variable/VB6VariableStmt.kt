package com.github.tyrrx.vb6language.psi.tree.definition.variable


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6VariableStmt : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val variablesDeclarations: List<VB6VariableSubRule>
}

class VB6VariableStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6VariableStmt {

    object Factory : IPsiNodeFactory<VB6VariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableStmt {
            return VB6VariableStmtImpl(node)
        }
    }

    override val variablesDeclarations: List<VB6VariableSubRule>
        get() = findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = variablesDeclarations

}