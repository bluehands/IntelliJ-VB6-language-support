package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode

interface VB6IfElseBlockStmt : VB6TransparentBlockScopeOwner {
}

class VB6IfElseBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfElseBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfElseBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfElseBlockStmt {
            return VB6IfElseBlockStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitIfElseBlockStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

}