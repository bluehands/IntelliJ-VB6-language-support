package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleAttributes : VB6PsiElement {
    fun getAttributes(): List<VB6AttributeStmt>
}

class VB6ModuleAttributesImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleAttributes {
    override fun getAttributes(): List<VB6AttributeStmt> {
        return findPsiElementsInDirectChildrenByType(this)
    }

    object Factory : IPsiNodeFactory<VB6ModuleAttributes> {
        override fun createPsiNode(node: ASTNode): VB6ModuleAttributes {
            return VB6ModuleAttributesImpl(node)
        }
    }
}