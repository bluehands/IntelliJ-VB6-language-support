package com.github.tyrrx.vb6language.psi.tree.nodes.impl


import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AsTypeClause
import com.intellij.lang.ASTNode

class VB6AsTypeClauseImpl(node: ASTNode) : VB6PsiNode(node), VB6AsTypeClause {

    object Factory : IPsiNodeFactory<VB6AsTypeClause> {
        override fun createPsiNode(node: ASTNode): VB6AsTypeClause {
            return VB6AsTypeClauseImpl(node)
        }
    }
}