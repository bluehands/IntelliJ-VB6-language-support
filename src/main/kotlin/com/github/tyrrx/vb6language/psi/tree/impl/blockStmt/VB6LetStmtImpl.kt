package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6LetStmt
import com.intellij.lang.ASTNode

class VB6LetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LetStmt {

    object Factory : IPsiNodeFactory<VB6LetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LetStmt {
            return VB6LetStmtImpl(node)
        }
    }
}