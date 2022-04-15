package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleBody : VB6PsiElement {
    fun getStatements(): List<VB6PsiElement>
}

class VB6ModuleBodyImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleBody {

    object Factory : IPsiNodeFactory<VB6ModuleBody> {
        override fun createPsiNode(node: ASTNode): VB6ModuleBody {
            return VB6ModuleBodyImpl(node)
        }
    }

    override fun getStatements(): List<VB6PsiElement> {
        return findPsiElementsInDirectChildrenByType<VB6ModuleBodyElement>(this)
            .map { it.getStatement() }
    }
}