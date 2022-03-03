package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6BaseType
import com.intellij.lang.ASTNode

class VB6BaseTypeImpl(node: ASTNode) : VB6PsiNode(node), VB6BaseType {

    object Factory : IPsiNodeFactory<VB6BaseType> {
        override fun createPsiNode(node: ASTNode): VB6BaseType {
            return VB6BaseTypeImpl(node)
        }
    }
}