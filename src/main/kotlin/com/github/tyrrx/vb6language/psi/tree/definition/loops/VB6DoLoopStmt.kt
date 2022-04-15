package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.intellij.lang.ASTNode

interface VB6DoLoopStmt :
    VB6PsiElement,
        VB6TransparentBlockScopeOwner {
}

class VB6DoLoopStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DoLoopStmt {

    object Factory : IPsiNodeFactory<VB6DoLoopStmt> {
        override fun createPsiNode(node: ASTNode): VB6DoLoopStmt {
            return VB6DoLoopStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveDoLoopStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = block?.outsideVisibleNamedElements ?: emptyList()

}