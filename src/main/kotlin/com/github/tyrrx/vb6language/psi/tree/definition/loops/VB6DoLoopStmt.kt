package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6DoLoopStmt :
    VB6StatementBase,
    VB6WeakBlockScopeOwner {
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

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveDoLoopStmt(this)
    }

}