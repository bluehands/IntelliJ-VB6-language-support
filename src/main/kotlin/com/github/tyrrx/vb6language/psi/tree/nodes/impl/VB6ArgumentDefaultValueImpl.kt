package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6ArgumentDefaultValue
import com.intellij.lang.ASTNode

class VB6ArgumentDefaultValueImpl(node: ASTNode) : VB6PsiNode(node), VB6ArgumentDefaultValue {

    object Factory : IPsiNodeFactory<VB6ArgumentDefaultValue> {
        override fun createPsiNode(node: ASTNode): VB6ArgumentDefaultValue {
            return VB6ArgumentDefaultValueImpl(node)
        }
    }
}