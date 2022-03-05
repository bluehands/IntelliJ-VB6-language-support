package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6ConstSubStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

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