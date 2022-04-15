package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ConstBase :
    VB6PsiElement,
        VB6NamedElementOwner,
        VB6TypeClauseOwner,
        VB6TypeHintMixin

interface VB6BlockConst : VB6ConstBase
interface VB6ModuleConst : VB6ConstBase, VB6VisibilityOwner

interface VB6ConstStmt : VB6ModuleConst, VB6BlockConst

class VB6ConstStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ConstStmt {

    object Factory : IPsiNodeFactory<VB6ConstStmt> {
        override fun createPsiNode(node: ASTNode): VB6ConstStmt {
            return VB6ConstStmtImpl(node)
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override val isDefinition: Boolean
        get() = true

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)
    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = TODO("Not yet implemented")

    override val visibility: VB6VisibilityEnum
        get() {
            return when (val moduleConstList = parent) {
                is VB6ModuleConstList -> moduleConstList.visibility?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
                else -> VB6VisibilityEnum.PUBLIC
            }
        }

    override val typeClause: VB6AsTypeClause? = findFirstChildByType(this)
}