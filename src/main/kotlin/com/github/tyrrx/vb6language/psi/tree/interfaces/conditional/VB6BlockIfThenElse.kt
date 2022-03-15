package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6BlockIfThenElse:PsiElement {
}

class VB6BlockIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockIfThenElse {

    object Factory : IPsiNodeFactory<VB6BlockIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6BlockIfThenElse {
            return VB6BlockIfThenElseImpl(node)
        }
    }
}