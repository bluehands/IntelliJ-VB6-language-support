package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6OnGoSubStmt : VB6PsiElement {
}

class VB6OnGoSubStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6OnGoSubStmt {

    object Factory : IPsiNodeFactory<VB6OnGoSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6OnGoSubStmt {
            return VB6OnGoSubStmtImpl(node)
        }
    }
}