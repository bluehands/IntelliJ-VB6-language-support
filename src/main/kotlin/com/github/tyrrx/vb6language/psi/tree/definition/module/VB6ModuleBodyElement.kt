package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ModuleBodyElement : VB6PsiElement {
    fun getStatement(): VB6PsiElement
}

class VB6ModuleBodyElementImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleBodyElement {

    object Factory : IPsiNodeFactory<VB6ModuleBodyElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleBodyElement {
            return VB6ModuleBodyElementImpl(node)
        }
    }

    override fun getStatement(): VB6PsiElement {
        return firstChild as VB6PsiElement
    }
}