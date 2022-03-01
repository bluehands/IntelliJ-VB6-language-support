package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Value
import com.intellij.lang.ASTNode

class VB6ValueImpl(node: ASTNode) : VB6PsiNode(node), VB6Value {

    object Factory: IPsiNodeFactory<VB6Value> {
        override fun createPsiNode(node: ASTNode): VB6Value {
            return VB6ValueImpl(node)
        }
    }
}