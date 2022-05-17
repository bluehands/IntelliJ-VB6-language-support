package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6StopStmt : VB6PsiElement {
}

class VB6StopStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6StopStmt {

    object Factory : IPsiNodeFactory<VB6StopStmt> {
        override fun createPsiNode(node: ASTNode): VB6StopStmt {
            return VB6StopStmtImpl(node)
        }
    }
}