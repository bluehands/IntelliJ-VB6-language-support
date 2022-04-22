package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ModuleVariableStmt : VB6EnclosingVisibleNamedElements, VB6PsiElement {
    val variableDeclarations: List<VB6VariableSubRule>
    val visibility: VB6Visibility?
}

class VB6ModuleVariableStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleVariableStmt {

    object Factory : IPsiNodeFactory<VB6ModuleVariableStmt> {
        override fun createPsiNode(node: ASTNode): VB6ModuleVariableStmt {
            return VB6ModuleVariableStmtImpl(node)
        }
    }

    override val variableDeclarations: List<VB6VariableSubRule>
        get() = findFirstChildByType<VB6VariableListStmt>(this)
            ?.getVariableDefinitions() ?: emptyList()

    override val visibility: VB6Visibility?
        get() = findFirstChildByType(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = variableDeclarations

}