package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6InlineCall
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6Literal
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6AttributeStmt : VB6PsiElement, VB6NamedElementOwner, VB6NamedElement {
    val literals: Collection<VB6Literal>
}

class VB6AttributeStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AttributeStmt {

    object Factory : IPsiNodeFactory<VB6AttributeStmt> {
        override fun createPsiNode(node: ASTNode): VB6AttributeStmt {
            return VB6AttributeStmtImpl(node)
        }
    }

    override val literals: Collection<VB6Literal> = findPsiElementsInDirectChildrenByType(this)

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType<VB6InlineCall>(this)
            ?.let { findPsiElementInSubtree(it) }
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")

    override val referenceOwner: VB6ReferenceOwner?
        get() = null

    override val namedElementOwner: VB6NamedElementOwner?
        get() = this

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VB6AttributeStmtImpl

        if (literals != other.literals) return false

        return true
    }

    override fun hashCode(): Int {
        return literals.hashCode()
    }

    override val isDefinition: Boolean
        get() = true


}