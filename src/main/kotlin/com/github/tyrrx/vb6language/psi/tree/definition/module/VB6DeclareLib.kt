package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6StringLiteral
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.intellij.lang.ASTNode

interface VB6DeclareLib : VB6PsiElement {
    val stringLiteral: VB6StringLiteral?
}

class VB6DeclareLibImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareLib {
    object Factory : IPsiNodeFactory<VB6DeclareLib> {
        override fun createPsiNode(node: ASTNode): VB6DeclareLib {
            return VB6DeclareLibImpl(node)
        }
    }

    override val stringLiteral: VB6StringLiteral?
        get() = findFirstChildByTypeOf(this)
}