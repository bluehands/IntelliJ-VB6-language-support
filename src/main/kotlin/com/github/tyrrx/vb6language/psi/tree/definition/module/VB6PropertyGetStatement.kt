package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PropertyStatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReturnTypeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6Type
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6PropertyGetStatement :
    VB6PropertyStatementBase,
    VB6ReturnTypeOwner,
    VB6TypeHintMixin {
}

class VB6PropertyGetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertyGetStatement {

    object Factory : IPsiNodeFactory<VB6PropertyGetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertyGetStatement {
            return VB6PropertyGetStatementImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolvePropertyGetStmt(this)
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this // todo check setName
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)
            ?.getArguments() ?: emptyList()

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }

    override fun getReturnAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getReturnType(): VB6Type? {
        return getReturnAsTypeClause()
            ?.getTypeRule()
            ?.getComplexOrBaseType()
    }

    override val isDefinition: Boolean
        get() = true
}