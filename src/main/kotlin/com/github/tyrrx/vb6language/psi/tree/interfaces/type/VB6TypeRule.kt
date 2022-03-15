package com.github.tyrrx.vb6language.psi.tree.interfaces.type

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.intellij.lang.ASTNode

interface VB6TypeRule: VB6PsiElement {
    fun getComplexOrBaseType(): VB6TypeBase
}

class VB6TypeRuleImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeRule {

    object Factory : IPsiNodeFactory<VB6TypeRule> {
        override fun createPsiNode(node: ASTNode): VB6TypeRule {
            return VB6TypeRuleImpl(node)
        }
    }

    override fun getComplexOrBaseType(): VB6TypeBase {
        return firstChild as VB6TypeBase
    }
}
