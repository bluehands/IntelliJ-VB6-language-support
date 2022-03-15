package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6ChdirStmt : VB6Statement {
}

class VB6ChdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ChdirStmt {

    object Factory : IPsiNodeFactory<VB6ChdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6ChdirStmt {
            return VB6ChdirStmtImpl(node)
        }
    }
}