package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleBodyElement : PsiElement{
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