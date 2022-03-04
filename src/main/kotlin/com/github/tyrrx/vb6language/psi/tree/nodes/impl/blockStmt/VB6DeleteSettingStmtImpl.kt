package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6DeleteSettingStmt
import com.intellij.lang.ASTNode

class VB6DeleteSettingStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DeleteSettingStmt {

    object Factory : IPsiNodeFactory<VB6DeleteSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeleteSettingStmt {
            return VB6DeleteSettingStmtImpl(node)
        }
    }
}