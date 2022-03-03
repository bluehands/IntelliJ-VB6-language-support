package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6MacroStatement
import com.intellij.lang.ASTNode


class VB6MacroStatementImpl(node: ASTNode) : VB6PsiNode(node), VB6MacroStatement {
    object Factory : IPsiNodeFactory<VB6MacroStatement> {
        override fun createPsiNode(node: ASTNode): VB6MacroStatement {
            return VB6MacroStatementImpl(node)
        }
    }
}