package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ConstStmt : VB6StatementBase,
    VB6GetVisibilityFromChildrenMixin {
    fun getDeclarations(): List<VB6ConstSubStmt>
}

class VB6ConstStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ConstStmt {

    object Factory : IPsiNodeFactory<VB6ConstStmt> {
        override fun createPsiNode(node: ASTNode): VB6ConstStmt {
            return VB6ConstStmtImpl(node)
        }
    }

    override fun getDeclarations(): List<VB6ConstSubStmt> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}