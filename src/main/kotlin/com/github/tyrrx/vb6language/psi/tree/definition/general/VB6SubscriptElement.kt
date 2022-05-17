package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6SubscriptElement : VB6PsiElement {
    // todo implement
}

class VB6SubscriptElementImpl(node: ASTNode) : VB6PsiNode(node), VB6SubscriptElement {

    object Factory : IPsiNodeFactory<VB6SubscriptElement> {
        override fun createPsiNode(node: ASTNode): VB6SubscriptElement {
            return VB6SubscriptElementImpl(node)
        }
    }
}