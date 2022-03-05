package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6BlockIfThenElse
import com.intellij.lang.ASTNode

class VB6BlockIfThenElseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6BlockIfThenElse {

    object Factory : IPsiNodeFactory<VB6BlockIfThenElse> {
        override fun createPsiNode(node: ASTNode): VB6BlockIfThenElse {
            return VB6BlockIfThenElseImpl(node)
        }
    }
}