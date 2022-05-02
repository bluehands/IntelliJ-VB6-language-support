package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6VariableList : VB6PsiElement {
    fun getVariableDefinitions(): List<VB6VariableListElement>
}

class VB6VariableListImpl(node: ASTNode) : VB6PsiNode(node), VB6VariableList {

    object Factory : IPsiNodeFactory<VB6VariableList> {
        override fun createPsiNode(node: ASTNode): VB6VariableList {
            return VB6VariableListImpl(node)
        }
    }

    override fun getVariableDefinitions(): List<VB6VariableListElement> {
        return findChildElementsByTypeOf(this)
    }
}