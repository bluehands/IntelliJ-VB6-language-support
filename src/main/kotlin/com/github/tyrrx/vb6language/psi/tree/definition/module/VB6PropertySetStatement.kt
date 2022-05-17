package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6PropertyDeclaration
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6PropertySetStatement : VB6PropertyDeclaration {
}

class VB6PropertySetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertySetStatement {

    object Factory : IPsiNodeFactory<VB6PropertySetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertySetStatement {
            return VB6PropertySetStatementImpl(node)
        }
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val block: VB6Block?
        get() = findFirstChildByTypeOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitPropertySetStmt(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitPropertySetStmt(this)
    }


    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByTypeOf<VB6ArgumentList>(this)
            ?.arguments() ?: emptyList()

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByTypeOf(this)
    }

    override val isDefinition: Boolean
        get() = true
}