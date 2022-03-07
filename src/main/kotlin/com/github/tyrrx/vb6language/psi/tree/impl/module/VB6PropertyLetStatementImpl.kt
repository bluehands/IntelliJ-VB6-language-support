package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6PropertyLetStatement
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveInBlockScopeOrParentContext
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveSelf
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6PropertyLetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertyLetStatement {

    object Factory : IPsiNodeFactory<VB6PropertyLetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertyLetStatement {
            return VB6PropertyLetStatementImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(element: VB6ReferenceOwner?): VB6IdentifierOwner? {
        return tryResolveSelf(this, element)
            ?: tryResolveInBlockScopeOrParentContext(this, element)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getArguments(): List<VB6Argument> {
        return findFirstChildByType<VB6ArgumentList>(this)
            ?.getArguments() ?: emptyList()
    }

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }
}