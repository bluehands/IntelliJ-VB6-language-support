package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6SaveSettingStmt : VB6PsiElement {
}

class VB6SaveSettingStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SaveSettingStmt {

    object Factory : IPsiNodeFactory<VB6SaveSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6SaveSettingStmt {
            return VB6SaveSettingStmtImpl(node)
        }
    }
}