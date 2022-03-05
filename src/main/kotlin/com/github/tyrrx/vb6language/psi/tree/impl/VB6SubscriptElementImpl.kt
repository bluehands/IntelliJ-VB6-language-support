package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6SubscriptElement
import com.intellij.lang.ASTNode

class VB6SubscriptElementImpl(node: ASTNode) : VB6PsiNode(node), VB6SubscriptElement {

    object Factory : IPsiNodeFactory<VB6SubscriptElement> {
        override fun createPsiNode(node: ASTNode): VB6SubscriptElement {
            return VB6SubscriptElementImpl(node)
        }
    }
}