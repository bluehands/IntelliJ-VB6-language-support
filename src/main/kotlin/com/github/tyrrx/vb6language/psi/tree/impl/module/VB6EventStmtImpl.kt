package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6EventStmt
import com.intellij.lang.ASTNode

class VB6EventStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EventStmt {

    object Factory : IPsiNodeFactory<VB6EventStmt> {
        override fun createPsiNode(node: ASTNode): VB6EventStmt {
            return VB6EventStmtImpl(node)
        }
    }
}