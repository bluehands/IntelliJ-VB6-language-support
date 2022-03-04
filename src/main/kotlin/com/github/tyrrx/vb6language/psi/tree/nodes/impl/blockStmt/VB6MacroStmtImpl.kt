package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6MacroStmt
import com.intellij.lang.ASTNode

class VB6MacroStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6MacroStmt {

    object Factory : IPsiNodeFactory<VB6MacroStmt> {
        override fun createPsiNode(node: ASTNode): VB6MacroStmt {
            return VB6MacroStmtImpl(node)
        }
    }
}