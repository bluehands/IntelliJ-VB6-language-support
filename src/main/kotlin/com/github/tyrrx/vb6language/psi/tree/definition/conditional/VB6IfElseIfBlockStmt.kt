package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode

interface VB6IfElseIfBlockStmt : VB6TransparentBlockScopeOwner {
}

class VB6IfElseIfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfElseIfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfElseIfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfElseIfBlockStmt {
            return VB6IfElseIfBlockStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByTypeOf(this)

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitIfElseIfStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

}