package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
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
        get() = findFirstChildByTypeOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitWhileWendStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()
}