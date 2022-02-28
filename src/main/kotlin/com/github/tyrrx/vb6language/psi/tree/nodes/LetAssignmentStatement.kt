package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class LetAssignmentStatement(node: ASTNode) : VB6PsiNode(node) {

    object Factory : IPsiNodeFactory<LetAssignmentStatement> {
        override fun createPsiNode(node: ASTNode): LetAssignmentStatement {
            return LetAssignmentStatement(node)
        }
    }
}