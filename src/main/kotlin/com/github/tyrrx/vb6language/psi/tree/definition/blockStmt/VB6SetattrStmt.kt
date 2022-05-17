package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6SetattrStmt : VB6PsiElement {
}

class VB6SetattrStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SetattrStmt {

    object Factory : IPsiNodeFactory<VB6SetattrStmt> {
        override fun createPsiNode(node: ASTNode): VB6SetattrStmt {
            return VB6SetattrStmtImpl(node)
        }
    }
}