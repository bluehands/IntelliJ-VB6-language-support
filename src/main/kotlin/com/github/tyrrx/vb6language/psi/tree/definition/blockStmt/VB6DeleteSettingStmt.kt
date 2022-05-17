package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6DeleteSettingStmt : VB6PsiElement {
}

class VB6DeleteSettingStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DeleteSettingStmt {

    object Factory : IPsiNodeFactory<VB6DeleteSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeleteSettingStmt {
            return VB6DeleteSettingStmtImpl(node)
        }
    }
}