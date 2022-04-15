package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.mixins.VB6VisibilityOwnerMixin
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6SubroutineStatement :
    VB6EnclosingVisibleNamedElements,
    VB6BlockScopeOwner,
    VB6NamedElementOwner,
    VB6ArgumentOwner,
        VB6VisibilityOwnerMixin,
        VB6IsStaticInChildrenMixin {
}

class VB6SubroutineStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6SubroutineStatement {

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this)

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveSubroutineStmt(this)
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override val arguments: List<VB6Argument>
        get() = findFirstChildByType<VB6ArgumentList>(this)
            ?.arguments() ?: emptyList()

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return findFirstChildByType(this)
    }

    object Factory : IPsiNodeFactory<VB6SubroutineStatementImpl> {
        override fun createPsiNode(node: ASTNode): VB6SubroutineStatementImpl {
            return VB6SubroutineStatementImpl(node)
        }
    }

    override fun getReference(): VB6Reference? {
        return null
    }

    override val isDefinition: Boolean
        get() = true
}