package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6DoLoopStmt :
    VB6Statement,
    VB6BlockScope {
}

class VB6DoLoopStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6DoLoopStmt {

    object Factory : IPsiNodeFactory<VB6DoLoopStmt> {
        override fun createPsiNode(node: ASTNode): VB6DoLoopStmt {
            return VB6DoLoopStmtImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveDoLoopStmt(this)
    }

}