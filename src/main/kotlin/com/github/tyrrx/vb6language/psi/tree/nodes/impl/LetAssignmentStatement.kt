package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.intellij.lang.ASTNode

class LetAssignmentStatement(node: ASTNode) : VB6PsiNode(node) {

    object Factory : IPsiNodeFactory<LetAssignmentStatement> {
        override fun createPsiNode(node: ASTNode): LetAssignmentStatement {
            return LetAssignmentStatement(node)
        }
    }
}