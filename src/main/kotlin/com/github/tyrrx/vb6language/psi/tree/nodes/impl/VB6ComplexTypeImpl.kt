package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6ComplexType
import com.intellij.lang.ASTNode

class VB6ComplexTypeImpl(node: ASTNode) : VB6PsiNode(node), VB6ComplexType {

    object Factory : IPsiNodeFactory<VB6ComplexType> {
        override fun createPsiNode(node: ASTNode): VB6ComplexType {
            return VB6ComplexTypeImpl(node)
        }
    }
}