package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6Block : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val statements: List<VB6PsiElement>
}

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }

    override val statements: List<VB6PsiElement>
        get() = findPsiElementsInDirectChildrenByType<VB6BlockStmt>(this)
            .map { it.statement }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = statements
            .filterIsInstance<VB6EnclosingVisibleNamedElements>()
            .flatMap { it.outsideVisibleNamedElementOwners }

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = statements.filterIsInstance<VB6EnclosingVisibleNamedElements>().flatMap { it.outsideVisibleNamedElements }
}
