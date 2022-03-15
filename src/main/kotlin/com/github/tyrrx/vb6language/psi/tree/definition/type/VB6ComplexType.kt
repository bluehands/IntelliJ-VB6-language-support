package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ComplexType: VB6TypeBase {
}

class VB6ComplexTypeImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ComplexType {

    object Factory : IPsiNodeFactory<VB6ComplexType> {
        override fun createPsiNode(node: ASTNode): VB6ComplexType {
            return VB6ComplexTypeImpl(node)
        }
    }
}