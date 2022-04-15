package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ArgumentList: VB6PsiElement {
    fun arguments(): List<VB6Argument>
}

class VB6ArgumentListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ArgumentList {

    object Factory : IPsiNodeFactory<VB6ArgumentList> {
        override fun createPsiNode(node: ASTNode): VB6ArgumentList {
            return VB6ArgumentListImpl(node)
        }
    }

    override fun arguments(): List<VB6Argument> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}