package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6InlineIfThenElse
import com.intellij.lang.ASTNode

class VB6InlineIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6InlineIfThenElse {

    object Factory : IPsiNodeFactory<VB6InlineIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6InlineIfThenElse {
            return VB6InlineIfThenElseImpl(node)
        }
    }
}