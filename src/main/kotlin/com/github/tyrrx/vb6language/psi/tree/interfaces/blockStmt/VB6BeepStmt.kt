package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6BeepStmt : VB6Statement {
}

class VB6BeepStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BeepStmt {

    object Factory : IPsiNodeFactory<VB6BeepStmt> {
        override fun createPsiNode(node: ASTNode): VB6BeepStmt {
            return VB6BeepStmtImpl(node)
        }
    }
}