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

interface VB6InlineProcedureOrArrayCall : VB6ReferenceFactory, VB6PsiElement {
}

class VB6InlineProcedureOrArrayCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineProcedureOrArrayCall {

    object Factory : IPsiNodeFactory<VB6InlineProcedureOrArrayCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineProcedureOrArrayCall {
            return VB6InlineProcedureOrArrayCallImpl(node)
        }
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