package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6EnumerationStmt : VB6Statement {
}

class VB6EnumerationStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6EnumerationStmt {

    object Factory : IPsiNodeFactory<VB6EnumerationStmt> {
        override fun createPsiNode(node: ASTNode): VB6EnumerationStmt {
            return VB6EnumerationStmtImpl(node)
        }
    }
}