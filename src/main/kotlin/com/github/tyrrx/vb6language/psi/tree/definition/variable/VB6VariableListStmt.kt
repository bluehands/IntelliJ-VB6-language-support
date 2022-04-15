package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6VariableListStmt : VB6PsiElement {
    fun getVariableDefinitions(): List<VB6VariableSubStmt>
}

class VB6VariableListStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6VariableListStmt {

    object Factory : IPsiNodeFactory<VB6VariableListStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableListStmt {
            return VB6VariableListStmtImpl(node)
        }
    }

    override fun getVariableDefinitions(): List<VB6VariableSubStmt> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}