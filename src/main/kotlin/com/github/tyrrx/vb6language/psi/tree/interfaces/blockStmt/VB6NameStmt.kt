package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6NameStmt : VB6Statement {
}

class VB6NameStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6NameStmt {

    object Factory : IPsiNodeFactory<VB6NameStmt> {
        override fun createPsiNode(node: ASTNode): VB6NameStmt {
            return VB6NameStmtImpl(node)
        }
    }
}