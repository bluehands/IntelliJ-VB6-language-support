package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6MacroStmt : VB6StatementBase {
}


class VB6MacroStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MacroStmt {

    object Factory : IPsiNodeFactory<VB6MacroStmt> {
        override fun createPsiNode(node: ASTNode): VB6MacroStmt {
            return VB6MacroStmtImpl(node)
        }
    }
}