package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6BlockStmt : VB6PsiElement {
    val statement: VB6PsiElement?
}

class VB6BlockStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6BlockStmt {

    object Factory : IPsiNodeFactory<VB6BlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6BlockStmt {
            return VB6BlockStmtImpl(node)
        }
    }

    override val statement: VB6PsiElement?
        get() = firstChild as? VB6PsiElement

}