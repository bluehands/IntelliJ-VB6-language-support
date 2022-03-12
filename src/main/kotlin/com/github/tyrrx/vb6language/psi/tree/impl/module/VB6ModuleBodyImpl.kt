package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleBody
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6ModuleBodyElement
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleBodyImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleBody {

    object Factory : IPsiNodeFactory<VB6ModuleBody> {
        override fun createPsiNode(node: ASTNode): VB6ModuleBody {
            return VB6ModuleBodyImpl(node)
        }
    }

    override fun getStatements(): List<PsiElement> {
        return findPsiElementsInDirectChildrenByType<VB6ModuleBodyElement>(this)
            .map { it.getStatement() }
    }
}