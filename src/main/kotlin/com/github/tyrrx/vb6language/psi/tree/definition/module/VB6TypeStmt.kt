package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6TypeStmt : VB6Statement {
}

class VB6TypeStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeStmt {

    object Factory : IPsiNodeFactory<VB6TypeStmt> {
        override fun createPsiNode(node: ASTNode): VB6TypeStmt {
            return VB6TypeStmtImpl(node)
        }
    }
}