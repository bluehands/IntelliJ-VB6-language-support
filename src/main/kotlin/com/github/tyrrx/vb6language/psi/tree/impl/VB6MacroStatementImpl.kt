package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6MacroStatement
import com.intellij.lang.ASTNode


class VB6MacroStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6MacroStatement {
    object Factory : IPsiNodeFactory<VB6MacroStatement> {
        override fun createPsiNode(node: ASTNode): VB6MacroStatement {
            return VB6MacroStatementImpl(node)
        }
    }
}