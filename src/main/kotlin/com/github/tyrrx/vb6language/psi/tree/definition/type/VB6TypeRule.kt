package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6TypeRule : VB6PsiElement {
    val type: VB6TypeElement?
}

class VB6TypeRuleImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeRule {

    object Factory : IPsiNodeFactory<VB6TypeRule> {
        override fun createPsiNode(node: ASTNode): VB6TypeRule {
            return VB6TypeRuleImpl(node)
        }
    }

    override val type: VB6TypeElement?
        get() = when (val child = firstChild) {
            is VB6TypeElement -> child
            else -> null
        }
}
