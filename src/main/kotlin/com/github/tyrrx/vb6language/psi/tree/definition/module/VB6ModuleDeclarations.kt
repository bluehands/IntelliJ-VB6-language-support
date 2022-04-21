package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleDeclarations : VB6PsiElement {
    val elements: List<VB6ModuleDeclarationsElement>
}

class VB6ModuleDeclarationsImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclarations {

    object Factory : IPsiNodeFactory<VB6ModuleDeclarations> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarations {
            return VB6ModuleDeclarationsImpl(node)
        }
    }

    override val elements: List<VB6ModuleDeclarationsElement>
        get() = findPsiElementsInDirectChildrenByType(this)
}