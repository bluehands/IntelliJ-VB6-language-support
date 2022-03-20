package com.github.tyrrx.vb6language.psi.tree.definition.loops


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6ForEachStmt :
    VB6StatementBase,
    VB6WeakBlockScopeOwner,
    VB6IdentifierOwner,
    VB6GetTypeHintFromChildrenMixin {
}

class VB6ForEachStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ForEachStmt {

    object Factory : IPsiNodeFactory<VB6ForEachStmt> {
        override fun createPsiNode(node: ASTNode): VB6ForEachStmt {
            return VB6ForEachStmtImpl(node)
        }
    }

    override val block: VB6Block?
        get() = findFirstChildByType(this)

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveForEachStmt(this)
    }


    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
        // todo match better as there are two
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}