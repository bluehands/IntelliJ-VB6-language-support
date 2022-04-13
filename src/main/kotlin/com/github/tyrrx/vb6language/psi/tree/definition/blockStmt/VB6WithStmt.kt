package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode

interface VB6WithStmt : VB6TransparentBlockScopeOwner, VB6PsiElement {
}

class VB6WithStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WithStmt {

    object Factory : IPsiNodeFactory<VB6WithStmt> {
        override fun createPsiNode(node: ASTNode): VB6WithStmt {
            return VB6WithStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveWithStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = block?.outsideVisibleNamedElements ?: emptyList()
}