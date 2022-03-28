package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6SubscriptElement
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Subscripts
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6VariableSubStmt: VB6BlockVariable, VB6ModuleVariable {
}

class VB6VariableSubStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6VariableSubStmt {

    object Factory : IPsiNodeFactory<VB6VariableSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6VariableSubStmt {
            return VB6VariableSubStmtImpl(node)
        }
    }

    override fun withEvents(): Boolean {
        return VB6IElementTypes.WITHEVENTS.isIElementTypePresentInChildren(parent.parent)
    }

    override fun getVisibility(): VB6VisibilityEnum {
        return findFirstChildByType<VB6Visibility>(parent.parent)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getSubscripts(): List<VB6SubscriptElement> {
        return findFirstChildByType<VB6Subscripts>(this)
            ?.getElements() ?: emptyList()
    }

    override fun isStatic(): Boolean {
        return VB6IElementTypes.STATIC.isIElementTypePresentInChildren(parent.parent)
    }

    override fun isArray(): Boolean {
        return getSubscripts().any() // todo correct or just LPAREN?
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this // todo correct?
    }

    override val isDefinition: Boolean
        get() = true
}