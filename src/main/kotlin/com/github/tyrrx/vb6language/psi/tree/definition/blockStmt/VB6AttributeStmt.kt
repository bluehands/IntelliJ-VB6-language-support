package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6InlineCall
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6Literal
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
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

    override val literals: Collection<VB6Literal>
        get() = findChildElementsByTypeOf(this)

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf<VB6InlineCall>(this)
                ?.let { findPsiElementInSubtree(it) }
    }

    override fun setName(name: String): PsiElement {
        return this
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

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

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitAttribute(this)
    }
}