package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PropertyStatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6PropertySetStatement : VB6PropertyStatementBase {
}

class VB6PropertySetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertySetStatement {

    object Factory : IPsiNodeFactory<VB6PropertySetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertySetStatement {
            return VB6PropertySetStatementImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolvePropertySetStmt(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)
            ?.getArguments() ?: emptyList()

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }
}