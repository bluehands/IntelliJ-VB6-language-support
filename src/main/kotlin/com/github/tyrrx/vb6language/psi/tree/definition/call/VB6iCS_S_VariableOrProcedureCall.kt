package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstParentOfType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

interface VB6iCS_S_VariableOrProcedureCall : VB6PsiElement, VB6ReferenceFactory, VB6ReferenceOwner {
}

class VB6iCS_S_VariableOrProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_VariableOrProcedureCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_VariableOrProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_VariableOrProcedureCall {
            return VB6iCS_S_VariableOrProcedureCallImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory?
        get() = this

    override fun getReference(): VB6Reference? {
        return referenceFactory?.createReference()
    }

    override fun createReference(): VB6Reference? {
        val identifier = findFirstChildByType<VB6Identifier>(this)
        val referenceOwner = findFirstParentOfType<VB6ReferenceOwner>(this)
        return identifier?.let { id ->
            referenceOwner?.let { owner ->
                SymbolReference(owner, id, id.textRangeInParent)
            }
        }
    }
}