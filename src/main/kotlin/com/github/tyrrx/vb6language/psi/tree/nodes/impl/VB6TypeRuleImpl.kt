package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6TypeRule
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.base.VB6Type
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
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