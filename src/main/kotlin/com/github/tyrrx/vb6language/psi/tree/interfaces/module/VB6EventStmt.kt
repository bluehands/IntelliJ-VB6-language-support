package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6EventStmt : VB6Statement {
}

class VB6EventStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EventStmt {

    object Factory : IPsiNodeFactory<VB6EventStmt> {
        override fun createPsiNode(node: ASTNode): VB6EventStmt {
            return VB6EventStmtImpl(node)
        }
    }
}