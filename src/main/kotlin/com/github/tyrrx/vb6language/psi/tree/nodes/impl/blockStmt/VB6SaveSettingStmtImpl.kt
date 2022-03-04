package com.github.tyrrx.vb6language.psi.tree.nodes.impl.blockStmt


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.blockStmt.VB6SaveSettingStmt
import com.intellij.lang.ASTNode

class VB6SaveSettingStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6SaveSettingStmt {

    object Factory : IPsiNodeFactory<VB6SaveSettingStmt> {
        override fun createPsiNode(node: ASTNode): VB6SaveSettingStmt {
            return VB6SaveSettingStmtImpl(node)
        }
    }
}