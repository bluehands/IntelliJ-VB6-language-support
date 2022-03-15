package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleDeclarations : PsiElement {
    fun getElements(): List<VB6ModuleDeclarationsElement>
}

class VB6ModuleDeclarationsImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclarations {

    object Factory : IPsiNodeFactory<VB6ModuleDeclarations> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarations {
            return VB6ModuleDeclarationsImpl(node)
        }
    }

    override fun getElements(): List<VB6ModuleDeclarationsElement> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}