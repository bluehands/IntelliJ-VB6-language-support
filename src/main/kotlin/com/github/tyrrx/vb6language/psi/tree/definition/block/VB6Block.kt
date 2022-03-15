package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Block : PsiElement {
    fun getStatements(): List<VB6Statement>
}

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }

    override fun getStatements(): List<VB6Statement> {
        return findPsiElementsInDirectChildrenByType<VB6BlockStmt>(this)
            .map { it.getStatement() }
    }
}