package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ConstList : VB6PsiElement {
    val declarations: List<VB6BlockConst>
}

class VB6ConstListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ConstList {

    object Factory : IPsiNodeFactory<VB6ConstList> {
        override fun createPsiNode(node: ASTNode): VB6ConstList {
            return VB6ConstListImpl(node)
        }
    }

    override val declarations: List<VB6BlockConst>
        get() = findPsiElementsInDirectChildrenByType(this)
}
