package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6LineLabel
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6AmbiguousIdentifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6LineLabelImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LineLabel {

    object Factory : IPsiNodeFactory<VB6LineLabel> {
        override fun createPsiNode(node: ASTNode): VB6LineLabel {
            return VB6LineLabelImpl(node)
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
       return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}