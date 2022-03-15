package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6FilecopyStmt : VB6Statement {
}

class VB6FilecopyStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FilecopyStmt {

    object Factory : IPsiNodeFactory<VB6FilecopyStmt> {
        override fun createPsiNode(node: ASTNode): VB6FilecopyStmt {
            return VB6FilecopyStmtImpl(node)
        }
    }
}