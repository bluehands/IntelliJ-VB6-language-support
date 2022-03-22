package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.visitor.SymbolResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6ImplicitCallStmt_InStmt
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6iCS_S_DictionaryCall
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6iCS_S_ProcedureOrArrayCall
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6iCS_S_VariableOrProcedureCall
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

interface VB6LetStmt : VB6StatementBase, VB6IdentifierOwner {
    val implicitCallOrDefinition: VB6ImplicitCallStmt_InStmt
    val isDefinition: Boolean
}

class VB6LetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LetStmt {

    object Factory : IPsiNodeFactory<VB6LetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LetStmt {
            return VB6LetStmtImpl(node)
        }
    }

    override val implicitCallOrDefinition: VB6ImplicitCallStmt_InStmt
        get() = findFirstChildByType(this)!!

    override val isDefinition: Boolean
        get() = implicitCallOrDefinition.firstChild.reference?.resolve() != null

    override fun getNameIdentifier(): VB6Identifier? {
        return when (val referenceOwner = implicitCallOrDefinition.firstChild) {
            is VB6ReferenceOwner -> referenceOwner.identifier
            else -> TODO("err")
        }
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }
}