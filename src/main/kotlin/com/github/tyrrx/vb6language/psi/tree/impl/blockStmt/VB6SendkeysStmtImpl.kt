package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6SendkeysStmt
import com.intellij.lang.ASTNode

class VB6SendkeysStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SendkeysStmt {

    object Factory : IPsiNodeFactory<VB6SendkeysStmt> {
        override fun createPsiNode(node: ASTNode): VB6SendkeysStmt {
            return VB6SendkeysStmtImpl(node)
        }
    }
}