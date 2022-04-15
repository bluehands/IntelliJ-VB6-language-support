package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6ResumeStmt : VB6PsiElement {
}

class VB6ResumeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ResumeStmt {

    object Factory : IPsiNodeFactory<VB6ResumeStmt> {
        override fun createPsiNode(node: ASTNode): VB6ResumeStmt {
            return VB6ResumeStmtImpl(node)
        }
    }
}