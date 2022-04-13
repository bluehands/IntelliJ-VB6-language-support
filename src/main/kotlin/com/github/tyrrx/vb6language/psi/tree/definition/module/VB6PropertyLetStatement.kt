package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6PropertyLetStatement: VB6PropertyStatementBase {
}

class VB6PropertyLetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertyLetStatement {

    object Factory : IPsiNodeFactory<VB6PropertyLetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertyLetStatement {
            return VB6PropertyLetStatementImpl(node)
        }
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolvePropertyLetStmt(this)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)
            ?.arguments() ?: emptyList()

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    override val isDefinition: Boolean
        get() = true
}