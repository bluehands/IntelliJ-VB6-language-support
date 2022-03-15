package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.intellij.lang.ASTNode

interface VB6EnumerationStmt : VB6StatementBase {
}

class VB6EnumerationStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EnumerationStmt {

    object Factory : IPsiNodeFactory<VB6EnumerationStmt> {
        override fun createPsiNode(node: ASTNode): VB6EnumerationStmt {
            return VB6EnumerationStmtImpl(node)
        }
    }
}