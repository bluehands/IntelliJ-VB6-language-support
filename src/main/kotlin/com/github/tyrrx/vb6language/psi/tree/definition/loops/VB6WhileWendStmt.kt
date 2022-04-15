package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode

interface VB6WhileWendStmt : VB6TransparentBlockScopeOwner, VB6PsiElement {
}

class VB6WhileWendStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WhileWendStmt {

    object Factory : IPsiNodeFactory<VB6WhileWendStmt> {
        override fun createPsiNode(node: ASTNode): VB6WhileWendStmt {
            return VB6WhileWendStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveWhileWendStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = block?.outsideVisibleNamedElements ?: emptyList()
}