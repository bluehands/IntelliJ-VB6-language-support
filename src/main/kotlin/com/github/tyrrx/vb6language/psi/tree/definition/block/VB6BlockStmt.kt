package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6BlockStmt : PsiElement {
    val statement: VB6StatementBase
}

class VB6BlockStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6BlockStmt {

    object Factory : IPsiNodeFactory<VB6BlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6BlockStmt {
            return VB6BlockStmtImpl(node)
        }
    }

    override val statement: VB6StatementBase
        get() = firstChild as VB6StatementBase

}