package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6StringLiteral
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6DeclareAlias : VB6PsiElement {
    val stringLiteral: VB6StringLiteral?
}

class VB6DeclareAliasImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareAlias {
    object Factory : IPsiNodeFactory<VB6DeclareAlias> {
        override fun createPsiNode(node: ASTNode): VB6DeclareAlias {
            return VB6DeclareAliasImpl(node)
        }
    }

    override val stringLiteral: VB6StringLiteral?
        get() = findFirstChildByType(this)
}