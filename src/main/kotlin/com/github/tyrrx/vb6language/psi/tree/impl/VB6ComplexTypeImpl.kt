package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6ComplexType
import com.intellij.lang.ASTNode

class VB6ComplexTypeImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ComplexType {

    object Factory : IPsiNodeFactory<VB6ComplexType> {
        override fun createPsiNode(node: ASTNode): VB6ComplexType {
            return VB6ComplexTypeImpl(node)
        }
    }
}