package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.impl.VB6ArgumentListImpl
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6Type
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.interfaces.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInSubtree
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveInBlockScopeOrParentContext
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveSelf
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference

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
        return findFirstChildByType<VB6ArgumentListImpl>(this)
            ?.getArguments() ?: emptyList()
    }

    override fun getReturnAsTypeClause(): VB6AsTypeClause? {
        return findFirstChildByType(this)
    }

    override fun getReturnType(): VB6Type? {
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

    override fun getReference(): PsiReference? {
        return null
    }
}