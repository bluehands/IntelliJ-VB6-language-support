package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6InlineIfThenElse : VB6PsiElement {
}

class VB6InlineIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6InlineIfThenElse {

    object Factory : IPsiNodeFactory<VB6InlineIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6InlineIfThenElse {
            return VB6InlineIfThenElseImpl(node)
        }
    }
}