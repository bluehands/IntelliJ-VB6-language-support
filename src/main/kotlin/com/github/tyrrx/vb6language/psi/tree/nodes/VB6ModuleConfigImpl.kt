package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleConfig
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleConfigElement
import com.github.tyrrx.vb6language.psi.tree.findPsiElementsInSubtree
import com.intellij.lang.ASTNode

class VB6ModuleConfigImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleConfig {

    override fun getModuleConfigElements(): Collection<VB6ModuleConfigElement> {
        return findPsiElementsInSubtree(this)
    }

    object Factory : IPsiNodeFactory<VB6ModuleConfig> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConfig {
            return VB6ModuleConfigImpl(node)
        }
    }
}