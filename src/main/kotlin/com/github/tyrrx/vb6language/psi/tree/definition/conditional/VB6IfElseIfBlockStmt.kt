package com.github.tyrrx.vb6language.psi.tree.definition.conditional

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6WeakBlockScopeOwner
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6IfElseIfBlockStmt : VB6WeakBlockScopeOwner {
}

class VB6IfElseIfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfElseIfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfElseIfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfElseIfBlockStmt {
            return VB6IfElseIfBlockStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveIfElseIfStmt(this)
    }
}