package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6BlockIfThenElse : VB6PsiElement, VB6EnclosingTransparentBlocks {
}

class VB6BlockIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockIfThenElse {

    object Factory : IPsiNodeFactory<VB6BlockIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6BlockIfThenElse {
            return VB6BlockIfThenElseImpl(node)
        }
    }

    override val enclosingBlocks: List<VB6Block>
        get() = findPsiElementsInDirectChildrenByType<VB6TransparentBlockScopeOwner>(this)
            .mapNotNull { it.block }

    override val visibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = enclosingBlocks.flatMap { it.visibleNamedElementOwners }

    override val visibleNamedElements: List<VB6NamedElement>
        get() = enclosingBlocks.flatMap { it.visibleNamedElements }
}