package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6TransparentBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6IfBlockStmt : VB6TransparentBlockScopeOwner {
}

class VB6IfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfBlockStmt {
            return VB6IfBlockStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveIfBlockStmt(this)
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = block?.outsideVisibleNamedElementOwners ?: emptyList()

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = block?.outsideVisibleNamedElements ?: emptyList()

}