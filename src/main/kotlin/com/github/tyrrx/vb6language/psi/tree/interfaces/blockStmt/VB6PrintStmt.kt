package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6PrintStmt : VB6Statement {
}


class VB6PrintStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PrintStmt {

    object Factory : IPsiNodeFactory<VB6PrintStmt> {
        override fun createPsiNode(node: ASTNode): VB6PrintStmt {
            return VB6PrintStmtImpl(node)
        }
    }
}