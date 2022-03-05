package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Value
import com.intellij.lang.ASTNode

class VB6ValueImpl(node: ASTNode) : VB6PsiNode(node), VB6Value {

    object Factory: IPsiNodeFactory<VB6Value> {
        override fun createPsiNode(node: ASTNode): VB6Value {
            return VB6ValueImpl(node)
        }
    }
}