package com.github.tyrrx.vb6language.psi.tree.definition

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6SubscriptElement : PsiElement {
    // todo implement
}

class VB6SubscriptElementImpl(node: ASTNode) : VB6PsiNode(node), VB6SubscriptElement {

    object Factory : IPsiNodeFactory<VB6SubscriptElement> {
        override fun createPsiNode(node: ASTNode): VB6SubscriptElement {
            return VB6SubscriptElementImpl(node)
        }
    }
}