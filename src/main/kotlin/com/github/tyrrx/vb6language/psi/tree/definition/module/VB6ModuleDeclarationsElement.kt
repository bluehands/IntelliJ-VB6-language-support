package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.intellij.lang.ASTNode

interface VB6ModuleDeclarationsElement : VB6PsiElement {
    val declaration: VB6PsiElement?
}

class VB6ModuleDeclarationsElementImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclarationsElement {

    object Factory : IPsiNodeFactory<VB6ModuleDeclarationsElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarationsElement {
            return VB6ModuleDeclarationsElementImpl(node)
        }
    }

    override val declaration: VB6PsiElement?
        get() = when (val child = firstChild) {
            is VB6PsiElement -> child
            else -> null
        }
}