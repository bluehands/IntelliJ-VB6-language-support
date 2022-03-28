package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

interface VB6ConstBase :
    VB6PsiElement,
    VB6IdentifierOwner,
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

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val visibility: VB6VisibilityEnum
        get() {
            return when (val moduleConstList = parent) {
                is VB6ModuleConstList -> moduleConstList.visibility?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
                else -> VB6VisibilityEnum.PUBLIC
            }
        }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }
}