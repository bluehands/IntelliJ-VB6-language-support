package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6EnclosingWeakBlocks
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6WeakBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6BlockIfThenElse : VB6PsiElement, VB6EnclosingWeakBlocks {
}

class VB6BlockIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockIfThenElse {

    object Factory : IPsiNodeFactory<VB6BlockIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6BlockIfThenElse {
            return VB6BlockIfThenElseImpl(node)
        }
    }

    override val enclosingBlocks: List<VB6Block>
        get() = findPsiElementsInDirectChildrenByType<VB6WeakBlockScopeOwner>(this)
            .mapNotNull { it.block }
}