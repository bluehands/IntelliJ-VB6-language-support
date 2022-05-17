package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
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
        get() = findFirstChildByTypeOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitWithStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

}