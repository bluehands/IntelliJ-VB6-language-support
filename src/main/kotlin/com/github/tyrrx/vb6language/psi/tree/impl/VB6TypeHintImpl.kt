package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6TypeHint
import com.intellij.lang.ASTNode

class VB6TypeHintImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeHint {

    object Factory : IPsiNodeFactory<VB6TypeHint> {
        override fun createPsiNode(node: ASTNode): VB6TypeHint {
            return VB6TypeHintImpl(node)
        }
    }
}