package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.CallReference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

interface VB6eCS_ProcedureCall : VB6ReferenceOwner {

}

class VB6eCS_ProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6eCS_ProcedureCall {

    object Factory : IPsiNodeFactory<VB6eCS_ProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6eCS_ProcedureCall {
            return VB6eCS_ProcedureCallImpl(node)
        }
    }

    override fun getIdentifier(): VB6Identifier {
        return findFirstChildByType(this)!!
    }

    override fun getReference(): PsiReference {
        return CallReference(this)
    }
}

