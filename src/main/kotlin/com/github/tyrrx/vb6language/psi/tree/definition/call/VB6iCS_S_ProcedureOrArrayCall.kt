package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.definition.type.VB6BaseType
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

interface VB6iCS_S_ProcedureOrArrayCall : VB6ReferenceOwner {
}

class VB6iCS_S_ProcedureOrArrayCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_ProcedureOrArrayCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_ProcedureOrArrayCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_ProcedureOrArrayCall {
            return VB6iCS_S_ProcedureOrArrayCallImpl(node)
        }
    }

    override val identifier: VB6Identifier
        get() {
            return findFirstChildByType(this)!!
        }

    override fun getReference(): PsiReference? {
        return when (identifier) {
            is VB6BaseType -> null
            else -> SymbolReference(this, identifier.textRangeInParent)
        }
    }
}