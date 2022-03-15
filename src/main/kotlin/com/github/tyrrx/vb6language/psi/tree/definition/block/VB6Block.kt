package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6BlockVariableDefinition
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6VariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Block : PsiElement {
    val statements: List<VB6StatementBase>
    val definitions: List<VB6IdentifierOwner>
}

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }

    override val statements: List<VB6StatementBase>
        get() = findPsiElementsInDirectChildrenByType<VB6BlockStmt>(this)
            .map { it.statement }

    override val definitions: List<VB6IdentifierOwner>
        get() = statements.flatMap {
            when (it) {
                is VB6VariableStmt -> it.variables
                is VB6LineLabel -> listOf(it)
                is VB6ConstStmt -> it.declarations
                // Todo VB6DeftypeStmt
                else -> emptyList()
            }
        }

}
