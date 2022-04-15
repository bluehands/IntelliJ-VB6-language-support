package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6MacroStmt : VB6PsiElement {
}


class VB6MacroStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MacroStmt {

    object Factory : IPsiNodeFactory<VB6MacroStmt> {
        override fun createPsiNode(node: ASTNode): VB6MacroStmt {
            return VB6MacroStmtImpl(node)
        }
    }
}