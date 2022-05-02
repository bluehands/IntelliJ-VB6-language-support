package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode

interface VB6AsTypeClause : VB6PsiElement {
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
        return findFirstChildByTypeOf(this)
    }

    override val typeRule: VB6TypeRule?
        get() = findFirstChildByTypeOf(this)

}
