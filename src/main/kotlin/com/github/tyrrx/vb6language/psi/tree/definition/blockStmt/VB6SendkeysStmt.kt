package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6SendkeysStmt : VB6PsiElement {
}

class VB6SendkeysStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SendkeysStmt {

    object Factory : IPsiNodeFactory<VB6SendkeysStmt> {
        override fun createPsiNode(node: ASTNode): VB6SendkeysStmt {
            return VB6SendkeysStmtImpl(node)
        }
    }
}