package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6Subscripts : VB6PsiElement {
    fun getElements(): List<VB6SubscriptElement>
}

class VB6SubscriptsImpl(node: ASTNode) : VB6PsiNode(node), VB6Subscripts {

    object Factory : IPsiNodeFactory<VB6Subscripts> {
        override fun createPsiNode(node: ASTNode): VB6Subscripts {
            return VB6SubscriptsImpl(node)
        }
    }

    override fun getElements(): List<VB6SubscriptElement> {
        return findChildElementsByTypeOf(this)
    }
}