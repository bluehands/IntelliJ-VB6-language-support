package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6SeekStmt : VB6PsiElement {
}

class VB6SeekStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SeekStmt {

    object Factory : IPsiNodeFactory<VB6SeekStmt> {
        override fun createPsiNode(node: ASTNode): VB6SeekStmt {
            return VB6SeekStmtImpl(node)
        }
    }
}