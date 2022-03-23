package com.github.tyrrx.vb6language.psi.tree.definition.blockStmt


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6StatementBase
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6InlineCall
import com.github.tyrrx.vb6language.psi.tree.definition.call.VB6InlineVariableOrProcedureCall
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6LetStmt : VB6StatementBase, VB6IdentifierOwner {
    val callStatement: VB6InlineCall?
}

class VB6LetStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6LetStmt {

    object Factory : IPsiNodeFactory<VB6LetStmt> {
        override fun createPsiNode(node: ASTNode): VB6LetStmt {
            return VB6LetStmtImpl(node)
        }
    }

    override val callStatement: VB6InlineCall?
        get() = findFirstChildByType(this)

    override val isDefinition: Boolean
        get() = callStatementReference?.resolve() == null

    override fun getNameIdentifier(): VB6Identifier? {
        return callStatementReference?.referencingIdentifier
    }

    private val callStatementReference: VB6Reference?
        get() = when (val def = callStatement?.firstChild) {
            is VB6InlineVariableOrProcedureCall -> def.reference
            //Todo other cases
            else -> null
        }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        return nameIdentifier?.setName(name) ?: this
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}