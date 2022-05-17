package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6FunctionDeclaration
import com.github.tyrrx.vb6language.psi.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintOwnerMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6VisibilityOwnerMixin
import com.github.tyrrx.vb6language.psi.scope.VB6BlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6FunctionStatement :
        VB6FunctionDeclaration,
        VB6BlockScopeOwner,
        VB6VisibilityOwnerMixin,
        VB6IsStaticInChildrenMixin,
        VB6TypeHintOwnerMixin {

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
        return findFirstChildByTypeOf(this)
    }

    override val typeClause: VB6AsTypeClause?
        get() = findFirstChildByTypeOf(this)

    override val block: VB6Block?
        get() = findFirstChildByTypeOf(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitFunctionStmt(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitFunctionStmt(this)
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByTypeOf<VB6ArgumentList>(this)
                ?.arguments() ?: emptyList()

    override val isDefinition: Boolean
        get() = true
}