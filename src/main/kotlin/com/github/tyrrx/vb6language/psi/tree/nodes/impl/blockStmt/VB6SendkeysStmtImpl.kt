package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6SendkeysStmt
import com.intellij.lang.ASTNode

class VB6SendkeysStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6SendkeysStmt {

    object Factory : IPsiNodeFactory<VB6SendkeysStmt> {
        override fun createPsiNode(node: ASTNode): VB6SendkeysStmt {
            return VB6SendkeysStmtImpl(node)
        }
    }
}