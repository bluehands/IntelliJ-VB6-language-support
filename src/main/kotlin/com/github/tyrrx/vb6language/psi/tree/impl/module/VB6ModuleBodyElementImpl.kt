package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleBodyElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleBodyElementImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleBodyElement {

    object Factory : IPsiNodeFactory<VB6ModuleBodyElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleBodyElement {
            return VB6ModuleBodyElementImpl(node)
        }
    }

    override fun getStatement(): PsiElement {
        return firstChild
    }
}