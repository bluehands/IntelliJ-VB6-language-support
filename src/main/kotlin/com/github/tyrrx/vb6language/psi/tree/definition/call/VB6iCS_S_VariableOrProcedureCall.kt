package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.VariableOrProcedureReference
import com.github.tyrrx.vb6language.psi.reference.visitor.VariableOrProcedureReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

interface VB6iCS_S_VariableOrProcedureCall : VB6ReferenceOwner {
}

class VB6iCS_S_VariableOrProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_VariableOrProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_VariableOrProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_VariableOrProcedureCall {
            return VB6iCS_S_VariableOrProcedureCallImpl(node)
        }
    }

    override fun getIdentifier(): VB6Identifier {
        return findFirstChildByType(this)!!
    }

    override fun getReference(): PsiReference? {
        return VariableOrProcedureReference(this, getIdentifier().textRangeInParent)
    }
}