package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6SubscriptElement
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Subscripts
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.utils.isIElementTypePresentInChildren
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6VariableSubRuleImpl(node: ASTNode) : VB6PsiNode(node),
        VB6VariableSubRule {

    object Factory : IPsiNodeFactory<VB6VariableSubRule> {
        override fun createPsiNode(node: ASTNode): VB6VariableSubRule {
            return VB6VariableSubRuleImpl(node)
        }
    }

    override val withEvents: Boolean
        get() = VB6IElementTypes.WITHEVENTS.isIElementTypePresentInChildren(statementParent)

    override val visibility: VB6VisibilityEnum
        get() = when (val parent = statementParent) {
            is VB6ModuleVariableStmt -> parent.visibility?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
            else -> VB6VisibilityEnum.PUBLIC
        }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitVariableDeclaration(this)
    }


    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByType(this)

    override fun getSubscripts(): List<VB6SubscriptElement> {
        return findFirstChildByType<VB6Subscripts>(this)
                ?.getElements() ?: emptyList()
    }

    override val isModuleVariable: Boolean
        get() = statementParent is VB6ModuleVariableStmt

    override val statementParent: PsiElement
        get() = parent.parent

    override val isStatic: Boolean
        get() = VB6IElementTypes.STATIC.isIElementTypePresentInChildren(statementParent)

    override val isArray: Boolean
        get() = getSubscripts().any()

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner> = listOf(this)

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val isDefinition: Boolean = true
}