package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6AtomicInlineCall
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6InlineCall
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6LetStmt : VB6PsiElement, VB6NamedElementOwner {
    val inlineCall: VB6InlineCall?
}

class VB6LetStmtImpl(node: ASTNode) : VB6PsiNode(node),
        VB6LetStmt {

    object Factory : IPsiNodeFactory<VB6LetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LetStmt {
            return VB6LetStmtImpl(node)
        }
    }

    override val inlineCall: VB6InlineCall?
        get() = findFirstChildByType(this)

    override val isDefinition: Boolean
        get() {
            return callStatementReference?.let {
                it.resolve() == null
            } ?: false
        }

    override fun getNameIdentifier(): VB6NamedElement? {
        return callStatementReference?.referencingNamedElement
    }

    private val callStatementReference: VB6Reference?
        get() = when (val def = inlineCall?.firstChild) {
            is VB6AtomicInlineCall -> def.reference
            else -> null
        }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}