package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Block
import com.intellij.lang.ASTNode

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }
}