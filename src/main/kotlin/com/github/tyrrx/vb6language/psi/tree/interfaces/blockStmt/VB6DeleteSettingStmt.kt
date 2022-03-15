package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6DeleteSettingStmt : VB6Statement {
}

class VB6DeleteSettingStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DeleteSettingStmt {

    object Factory : IPsiNodeFactory<VB6DeleteSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeleteSettingStmt {
            return VB6DeleteSettingStmtImpl(node)
        }
    }
}