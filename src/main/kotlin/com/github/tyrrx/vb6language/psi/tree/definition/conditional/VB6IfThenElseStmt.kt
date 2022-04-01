package com.github.tyrrx.vb6language.psi.tree.definition.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.intellij.lang.ASTNode

interface VB6IfThenElseStmt : VB6StatementBase, VB6EnclosingTransparentBlocks {
}

class VB6IfThenElseStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfThenElseStmt {

    object Factory : IPsiNodeFactory<VB6IfThenElseStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfThenElseStmt {
            return VB6IfThenElseStmtImpl(node)
        }
    }

    override val enclosingBlocks: List<VB6Block>
        get() = when (val enclosingElement = firstChild) {
            is VB6BlockIfThenElse -> enclosingElement.enclosingBlocks
            else -> emptyList()
        }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = enclosingBlocks.flatMap { it.outsideVisibleNamedElementOwners }

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = enclosingBlocks.flatMap { it.outsideVisibleNamedElements }

}