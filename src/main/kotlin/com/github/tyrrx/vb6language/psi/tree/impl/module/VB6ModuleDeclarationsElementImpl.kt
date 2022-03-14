package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleDeclarationsElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleDeclarationsElementImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclarationsElement {

    object Factory : IPsiNodeFactory<VB6ModuleDeclarationsElement> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarationsElement {
            return VB6ModuleDeclarationsElementImpl(node)
        }
    }

    override fun getInnerElement(): VB6PsiElement {
        return firstChild as VB6PsiElement
    }
}