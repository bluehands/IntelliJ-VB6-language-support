package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Type
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6TypeRule
import com.intellij.lang.ASTNode

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