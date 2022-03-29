package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6AsTypeClause : VB6PsiElement {
    fun isAutoInitialized(): Boolean // default false
    fun getFieldLength(): VB6FieldLength?
    fun getTypeRule(): VB6TypeRule
}

class VB6AsTypeClauseImpl(node: ASTNode) : VB6PsiNode(node),
    VB6AsTypeClause {

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

    override fun getTypeRule(): VB6TypeRule {
        return findFirstChildByType(this)!!
    }
}
