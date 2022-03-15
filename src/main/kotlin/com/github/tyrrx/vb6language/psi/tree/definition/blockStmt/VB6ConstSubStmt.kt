package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

interface VB6ConstSubStmt:
    VB6IdentifierOwner,
    VB6VisibilityOwner,
    VB6TypeClauseOwner,
    VB6GetTypeHintFromChildrenMixin {
}

class VB6ConstSubStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ConstSubStmt {

    object Factory : IPsiNodeFactory<VB6ConstSubStmt> {
        override fun createPsiNode(node: ASTNode): VB6ConstSubStmt {
            return VB6ConstSubStmtImpl(node)
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getVisibility(): VB6VisibilityEnum {
        return PsiTreeUtil.getPrevSiblingOfType(this, VB6Visibility::class.java)
            ?.getEnumValue() ?: VB6VisibilityEnum.PUBLIC
    }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }
}