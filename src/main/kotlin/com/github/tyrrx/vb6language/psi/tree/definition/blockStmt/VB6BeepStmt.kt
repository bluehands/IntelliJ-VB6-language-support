package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6BeepStmt : VB6PsiElement {
}

class VB6BeepStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BeepStmt {

    object Factory : IPsiNodeFactory<VB6BeepStmt> {
        override fun createPsiNode(node: ASTNode): VB6BeepStmt {
            return VB6BeepStmtImpl(node)
        }
    }
}