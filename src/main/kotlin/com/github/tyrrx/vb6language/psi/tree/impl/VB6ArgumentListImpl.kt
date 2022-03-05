package com.github.tyrrx.vb6language.psi.tree.impl


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

class VB6ArgumentListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ArgumentList {

    object Factory : IPsiNodeFactory<VB6ArgumentList> {
        override fun createPsiNode(node: ASTNode): VB6ArgumentList {
            return VB6ArgumentListImpl(node)
        }
    }

    override fun getArguments(): List<VB6Argument> {
        return findPsiElementsInDirectChildrenByType(this)
    }
}