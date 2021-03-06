package com.github.tyrrx.vb6language.psi.tree.definition.conditional


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingTransparentBlocks
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.intellij.lang.ASTNode

interface VB6IfThenElseStmt : VB6PsiElement, VB6EnclosingTransparentBlocks {
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

}