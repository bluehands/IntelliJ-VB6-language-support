package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6WhileWendStmt : VB6WeakBlockScopeOwner, VB6StatementBase {
}

class VB6WhileWendStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6WhileWendStmt {

    object Factory : IPsiNodeFactory<VB6WhileWendStmt> {
        override fun createPsiNode(node: ASTNode): VB6WhileWendStmt {
            return VB6WhileWendStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveWhileWendStmt(this)
    }
}