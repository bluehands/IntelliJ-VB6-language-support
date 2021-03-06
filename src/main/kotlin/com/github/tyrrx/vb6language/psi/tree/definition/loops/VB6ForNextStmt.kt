package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintOwnerMixin
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6AsTypeClause
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ForNextStmt :
    VB6PsiElement,
    VB6TransparentBlockScopeOwner,
    VB6NamedElementOwner,
    VB6TypeClauseOwner,
    VB6TypeHintOwnerMixin {
    val iteratorDeclaration: VB6ForNextStmtIteratorDeclaration?
}

class VB6ForNextStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ForNextStmt {

    object Factory : IPsiNodeFactory<VB6ForNextStmt> {
        override fun createPsiNode(node: ASTNode): VB6ForNextStmt {
            return VB6ForNextStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByTypeOf(this)

    override val iteratorDeclaration: VB6ForNextStmtIteratorDeclaration?
        get() = findFirstChildByTypeOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitForNextStmt(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitForNextStmt(this)
    }

    override fun getNameIdentifier(): VB6NamedElement? {
        return iteratorDeclaration?.identifier
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        nameIdentifier?.setName(name)
        return this
    }

    override val typeClause: VB6AsTypeClause? get() = findFirstChildByTypeOf(this)

    override val isDefinition: Boolean
        get() = iteratorDeclaration?.let { iterator ->
            iterator.reference?.let { reference ->
                reference.resolve() == null
            }
        } ?: false

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = listOf(this) + (block?.outsideVisibleNamedElementOwners ?: emptyList())

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}