package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.intellij.lang.ASTNode

interface VB6TypeRule: VB6PsiElement {
    fun getComplexOrBaseType(): VB6Type
}

class VB6TypeRuleImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeRule {

    object Factory : IPsiNodeFactory<VB6TypeRule> {
        override fun createPsiNode(node: ASTNode): VB6TypeRule {
            return VB6TypeRuleImpl(node)
        }
    }

    override fun getComplexOrBaseType(): VB6Type {
        return firstChild as VB6Type
    }
}
