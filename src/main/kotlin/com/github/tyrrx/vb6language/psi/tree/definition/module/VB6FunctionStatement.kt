package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReturnTypeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6TypeBase
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6FunctionStatement :
    VB6BlockScope,
    VB6IdentifierOwner,
    VB6ArgumentOwner,
    VB6ReturnTypeOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin,
    VB6GetTypeHintFromChildrenMixin {

}

class VB6FunctionStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6FunctionStatement {

    object Factory : IPsiNodeFactory<VB6FunctionStatementImpl> {
        override fun createPsiNode(node: ASTNode): VB6FunctionStatementImpl {
            return VB6FunctionStatementImpl(node)
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }

    override fun getArguments(): List<VB6Argument> {
        return findFirstChildByType<VB6ArgumentList>(this)
            ?.getArguments() ?: emptyList()
    }

    override fun getReturnAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getReturnType(): VB6TypeBase? {
        return getReturnAsTypeClause()
            ?.getTypeRule()
            ?.getComplexOrBaseType()
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveFunctionStmt(this)
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }
}