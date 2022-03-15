package com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Statement
import com.intellij.lang.ASTNode

interface VB6SaveSettingStmt : VB6Statement {
}

class VB6SaveSettingStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SaveSettingStmt {

    object Factory : IPsiNodeFactory<VB6SaveSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6SaveSettingStmt {
            return VB6SaveSettingStmtImpl(node)
        }
    }
}