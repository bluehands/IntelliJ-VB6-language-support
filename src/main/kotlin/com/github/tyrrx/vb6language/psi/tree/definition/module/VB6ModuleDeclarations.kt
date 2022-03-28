package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleDeclarations : PsiElement {
    val elements: List<VB6ModuleDeclarationsElement>
}

class VB6ModuleDeclarationsImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclarations {

    object Factory : IPsiNodeFactory<VB6ModuleDeclarations> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarations {
            return VB6ModuleDeclarationsImpl(node)
        }
    }

    override val elements: List<VB6ModuleDeclarationsElement> get() {
        return findPsiElementsInDirectChildrenByType(this)
    }
}