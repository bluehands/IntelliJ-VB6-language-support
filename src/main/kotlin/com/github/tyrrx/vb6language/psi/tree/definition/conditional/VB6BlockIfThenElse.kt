package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingTransparentBlocks
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
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

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = enclosingBlocks.flatMap { it.outsideVisibleNamedElementOwners }

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = enclosingBlocks.flatMap { it.outsideVisibleNamedElements }
}