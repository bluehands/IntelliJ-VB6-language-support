package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6RmdirStmt : VB6Statement {
}

class VB6RmdirStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6RmdirStmt {

    object Factory : IPsiNodeFactory<VB6RmdirStmt> {
        override fun createPsiNode(node: ASTNode): VB6RmdirStmt {
            return VB6RmdirStmtImpl(node)
        }
    }
}