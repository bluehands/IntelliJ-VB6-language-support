package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6RaiseEventStmt : VB6PsiElement {
}

class VB6RaiseEventStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RaiseEventStmt {

    object Factory : IPsiNodeFactory<VB6RaiseEventStmt> {
        override fun createPsiNode(node: ASTNode): VB6RaiseEventStmt {
            return VB6RaiseEventStmtImpl(node)
        }
    }
}