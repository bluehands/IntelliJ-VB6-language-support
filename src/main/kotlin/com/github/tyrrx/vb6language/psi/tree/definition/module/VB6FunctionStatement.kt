package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6VisibilityOwnerMixin
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6FunctionStatement :
    VB6EnclosingVisibleNamedElements,
    VB6BlockScopeOwner,
    VB6NamedElementOwner,
    VB6ArgumentOwner,
    VB6ReturnTypeOwner,
    VB6TypeClauseOwner,
        VB6VisibilityOwnerMixin,
        VB6IsStaticInChildrenMixin,
        VB6TypeHintMixin {

}

class VB6FunctionStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FunctionStatement {

    object Factory : IPsiNodeFactory<VB6FunctionStatementImpl> {
        override fun createPsiNode(node: ASTNode): VB6FunctionStatementImpl {
            return VB6FunctionStatementImpl(node)
        }
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override fun getReturnAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getReturnType(): VB6TypeDeclaration? {
        return getReturnAsTypeClause()
            ?.typeRule
            ?.type
    }

    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByType(this)

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)
    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() //todo also this?

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveFunctionStmt(this)
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)
            ?.arguments() ?: emptyList()

    override val isDefinition: Boolean
        get() = true
}