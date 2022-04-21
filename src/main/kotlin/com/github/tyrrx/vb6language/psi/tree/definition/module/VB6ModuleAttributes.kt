package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleAttributes : VB6PsiElement {
    val attributes: List<VB6AttributeStmt>
}

class VB6ModuleAttributesImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleAttributes {

    override val attributes: List<VB6AttributeStmt>
        get() = findPsiElementsInDirectChildrenByType(this)

    object Factory : IPsiNodeFactory<VB6ModuleAttributes> {
        override fun createPsiNode(node: ASTNode): VB6ModuleAttributes {
            return VB6ModuleAttributesImpl(node)
        }
    }
}