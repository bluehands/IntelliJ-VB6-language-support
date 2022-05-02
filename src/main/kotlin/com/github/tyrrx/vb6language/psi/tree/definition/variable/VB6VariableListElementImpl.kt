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
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.isIElementTypePresentInChildren
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6VariableListElementImpl(node: ASTNode) : VB6PsiNode(node),
        VB6VariableListElement {

    object Factory : IPsiNodeFactory<VB6VariableListElement> {
        override fun createPsiNode(node: ASTNode): VB6VariableListElement {
            return VB6VariableListElementImpl(node)
        }
    }

    override val withEvents: Boolean
        get() = VB6IElementTypes.WITHEVENTS.isIElementTypePresentInChildren(parentVariableStmt)

    override val visibility: VB6VisibilityEnum
        get() = when (val parent = parentVariableStmt) {
            is VB6ModuleVariableStmt -> parent.visibility?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
            else -> VB6VisibilityEnum.PUBLIC
        }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitVariableDeclaration(this)
    }


    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByTypeOf(this)

    override fun getSubscripts(): List<VB6SubscriptElement> {
        return findFirstChildByTypeOf<VB6Subscripts>(this)
                ?.getElements() ?: emptyList()
    }

    override val isModuleVariable: Boolean
        get() = parentVariableStmt is VB6ModuleVariableStmt

    override val parentVariableStmt: PsiElement
        get() = parent.parent

    override val isStatic: Boolean
        get() = VB6IElementTypes.STATIC.isIElementTypePresentInChildren(parentVariableStmt)

    override val isArray: Boolean
        get() = getSubscripts().any()

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner> = listOf(this)

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
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