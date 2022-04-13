package com.github.tyrrx.vb6language.psi.tree.definition.literal

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Literal : VB6PsiElement {
    val literalElement: PsiElement?
}

class VB6LiteralImpl(node: ASTNode) : VB6PsiNode(node), VB6Literal {
    override val literalElement: PsiElement? = firstChild

    object Factory : IPsiNodeFactory<VB6Literal> {
        override fun createPsiNode(node: ASTNode): VB6Literal {
            return VB6LiteralImpl(node)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as VB6Literal
        if (literalElement != other.literalElement) return false
        return true
    }

    override fun hashCode(): Int {
        return literalElement?.hashCode() ?: 0
    }


}