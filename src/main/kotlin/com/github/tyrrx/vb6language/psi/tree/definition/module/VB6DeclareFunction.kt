package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6DeclareFunction : VB6PsiElement, VB6TypeHintMixin {

}

class VB6DeclareFunctionImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareFunction {
    object Factory : IPsiNodeFactory<VB6DeclareFunction> {
        override fun createPsiNode(node: ASTNode): VB6DeclareFunction {
            return VB6DeclareFunctionImpl(node)
        }
    }
}