package com.github.tyrrx.vb6language.psi.tree.impl.block


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6BlockStmt
import com.intellij.lang.ASTNode

class VB6BlockStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6BlockStmt {

    object Factory : IPsiNodeFactory<VB6BlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6BlockStmt {
            return VB6BlockStmtImpl(node)
        }
    }

    override fun getStatement(): VB6Statement {
        return firstChild as VB6Statement
    }
}