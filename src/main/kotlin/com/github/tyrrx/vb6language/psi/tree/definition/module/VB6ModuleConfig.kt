package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ModuleConfig: PsiElement {
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>
}

class VB6ModuleConfigImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConfig {

    override fun getModuleConfigElements(): Collection<VB6ModuleConfigElement> {
        return findPsiElementsInSubtree(this)
    }

    object Factory : IPsiNodeFactory<VB6ModuleConfig> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfig {
            return VB6ModuleConfigImpl(node)
        }
    }
}