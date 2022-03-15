package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6WidthStmt : VB6Statement {
}

class VB6WidthStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WidthStmt {

    object Factory : IPsiNodeFactory<VB6WidthStmt> {
        override fun createPsiNode(node: ASTNode): VB6WidthStmt {
            return VB6WidthStmtImpl(node)
        }
    }
}