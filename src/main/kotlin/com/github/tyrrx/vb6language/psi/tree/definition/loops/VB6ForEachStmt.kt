package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintMixin
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ForEachStmt :
    VB6PsiElement,
    VB6TransparentBlockScopeOwner,
    VB6NamedElementOwner,
    VB6TypeHintMixin {
    val iteratorDeclaration: VB6ForEachStmtIteratorDeclaration?
}

class VB6ForEachStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ForEachStmt {

    object Factory : IPsiNodeFactory<VB6ForEachStmt> {
        override fun createPsiNode(node: ASTNode): VB6ForEachStmt {
            return VB6ForEachStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitForEachStmt(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitForEachStmt(this)
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return iteratorDeclaration?.identifier
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override val isDefinition: Boolean
        get() = iteratorDeclaration?.let { iterator ->
            iterator.reference?.let { reference ->
                reference.resolve() == null
            }
        } ?: false

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this) + (block?.outsideVisibleNamedElementOwners ?: emptyList())

    override val iteratorDeclaration: VB6ForEachStmtIteratorDeclaration?
        get() = findFirstChildByType(this)

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}