package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6Expression: VB6PsiElement {
}

class VB6ExpressionImpl(node: ASTNode) : VB6PsiNode(node), VB6Expression {

    object Factory: IPsiNodeFactory<VB6Expression> {
        override fun createPsiNode(node: ASTNode): VB6Expression {
            return VB6ExpressionImpl(node)
        }
    }
}