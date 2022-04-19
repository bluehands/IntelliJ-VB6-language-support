package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6SubscriptElement
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Subscripts
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.utils.isIElementTypePresentInChildren
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

interface VB6VariableSubStmt : VB6BlockVariable, VB6ModuleVariable {
    val isModuleVariable: Boolean
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

    override val visibility: VB6VisibilityEnum = findFirstChildByType<VB6Visibility>(parent.parent)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC

    override val typeClause: VB6AsTypeClause? get() = findFirstChildByType(this)

    override fun getSubscripts(): List<VB6SubscriptElement> {
        return findFirstChildByType<VB6Subscripts>(this)
                ?.getElements() ?: emptyList()
    }

    override val isModuleVariable: Boolean
        get() = parent.parent.elementType == VB6IElementTypes.rules[VisualBasic6Parser.RULE_moduleVariableStmt]

    override fun isStatic(): Boolean {
        return VB6IElementTypes.STATIC.isIElementTypePresentInChildren(parent.parent)
    }

    override fun isArray(): Boolean {
        return getSubscripts().any() // todo correct or just LPAREN?
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this // todo correct?
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")

    override val isDefinition: Boolean
        get() = true
}