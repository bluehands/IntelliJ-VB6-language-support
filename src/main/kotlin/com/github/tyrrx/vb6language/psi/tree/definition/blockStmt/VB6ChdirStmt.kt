package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ChdirStmt : VB6PsiElement {
}

class VB6ChdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ChdirStmt {

    object Factory : IPsiNodeFactory<VB6ChdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdirStmt {
            return VB6ChdirStmtImpl(node)
        }
    }
}