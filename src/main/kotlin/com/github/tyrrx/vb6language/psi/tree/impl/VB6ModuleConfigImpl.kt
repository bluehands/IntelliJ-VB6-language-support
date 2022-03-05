package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleConfig
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleConfigElement
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode

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