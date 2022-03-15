package com.github.tyrrx.vb6language.psi.tree.interfaces.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6IfElseIfBlockStmt : VB6BlockScope {
}

class VB6IfElseIfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfElseIfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfElseIfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfElseIfBlockStmt {
            return VB6IfElseIfBlockStmtImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveIfElseIfStmt(this)
    }


}