package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode

interface VB6ModuleConfig : VB6PsiElement {
    val configElements: Collection<VB6ModuleConfigElement>
}

class VB6ModuleConfigImpl(node: ASTNode) : VB6PsiNode(node),
        VB6ModuleConfig {

    override val configElements: Collection<VB6ModuleConfigElement>
        get() = findPsiElementsInSubtree(this)

    object Factory : IPsiNodeFactory<VB6ModuleConfig> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfig {
            return VB6ModuleConfigImpl(node)
        }
    }
}