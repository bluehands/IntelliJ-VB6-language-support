package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleDeclarations
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleDeclarationsElement
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

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