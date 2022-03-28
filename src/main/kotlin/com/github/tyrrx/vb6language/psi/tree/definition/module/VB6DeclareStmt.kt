package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6DeclareStmt :
    VB6StatementBase,
    VB6IdentifierOwner,
    VB6TypeClauseOwner,
VB6ArgumentOwner {
}

class VB6DeclareStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareStmt {

    object Factory : IPsiNodeFactory<VB6DeclareStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeclareStmt {
            return VB6DeclareStmtImpl(node)
        }
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }


    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override fun getAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)?.getArguments() ?: emptyList()

    override val isDefinition: Boolean
        get() = true

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}