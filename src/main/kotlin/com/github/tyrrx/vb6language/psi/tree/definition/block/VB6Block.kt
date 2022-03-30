package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ConstList
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LetStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6VariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Block : PsiElement {
    val statements: List<VB6StatementBase>
    val namedElementOwners: List<VB6NamedElementOwner>
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

    override val namedElementOwners: List<VB6NamedElementOwner>
        get() = statements.flatMap {
            when (it) {
                is VB6VariableStmt -> it.variables
                is VB6LineLabel -> listOf(it)
                is VB6ConstList -> it.declarations
                is VB6WeakBlockScopeOwner -> it.block?.namedElementOwners ?: emptyList()
                is VB6EnclosingWeakBlocks -> it.enclosingBlocks.flatMap { block -> block.namedElementOwners }
                is VB6LetStmt -> listOf(it)
                // Todo VB6DeftypeStmt
                else -> emptyList()
            }
        }
}
