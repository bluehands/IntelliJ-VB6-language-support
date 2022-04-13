package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.reference.TypeReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode

interface VB6AsTypeClause : VB6ReferenceOwner, VB6ReferenceFactory, VB6PsiElement {
    fun isAutoInitialized(): Boolean // default false
    fun getFieldLength(): VB6FieldLength?
    val typeRule: VB6TypeRule?
}

class VB6AsTypeClauseImpl(node: ASTNode) : VB6PsiNode(node), VB6AsTypeClause {

    object Factory : IPsiNodeFactory<VB6AsTypeClause> {
        override fun createPsiNode(node: ASTNode): VB6AsTypeClause {
            return VB6AsTypeClauseImpl(node)
        }
    }

    override fun isAutoInitialized(): Boolean {
        return VB6IElementTypes.NEW.isIElementTypePresentInChildren(this)
    }

    override fun getFieldLength(): VB6FieldLength? {
        return findFirstChildByType(this)
    }

    override val typeRule: VB6TypeRule? get() = findFirstChildByType(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = this

    override fun createReference(): VB6Reference? {
        val identifier = when (val type = typeRule?.type) {
            is VB6ComplexType -> type.identifiers.firstOrNull()
            else -> null
        }
        // todo implement type member access
        return typeRule?.let { vB6TypeRule ->
            identifier?.let {
                val offset = vB6TypeRule.startOffsetInParent
                val textRange =
                    it.textRangeInParent.shiftRight(offset) // add the text len of "as " to this aka the startOffset of the typeRule
                TypeReference(this, it, textRange)
            }
        }
    }
}
