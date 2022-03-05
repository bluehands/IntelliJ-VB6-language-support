package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }

    override fun getBlockStatements(): List<VB6BlockStatement> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}