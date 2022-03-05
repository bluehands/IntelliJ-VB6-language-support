package com.github.tyrrx.vb6language.psi.tree.impl.module


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6DeclareStmt
import com.intellij.lang.ASTNode

class VB6DeclareStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareStmt {

    object Factory : IPsiNodeFactory<VB6DeclareStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeclareStmt {
            return VB6DeclareStmtImpl(node)
        }
    }
}