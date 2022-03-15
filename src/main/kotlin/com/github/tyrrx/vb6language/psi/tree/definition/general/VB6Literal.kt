package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Literal: PsiElement {
    fun getLiteralElement(): PsiElement
}

class VB6LiteralImpl(node: ASTNode) : VB6PsiNode(node), VB6Literal {
    override fun getLiteralElement(): PsiElement {
        return firstChild
    }

    object Factory: IPsiNodeFactory<VB6Literal> {
        override fun createPsiNode(node: ASTNode): VB6Literal {
            return VB6LiteralImpl(node)
        }
    }
}