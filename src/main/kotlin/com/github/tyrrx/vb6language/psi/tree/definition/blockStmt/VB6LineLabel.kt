package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6LineLabel : VB6PsiElement,
    VB6NamedElementOwner {
}

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

    override val isDefinition: Boolean
        get() = true

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")
}