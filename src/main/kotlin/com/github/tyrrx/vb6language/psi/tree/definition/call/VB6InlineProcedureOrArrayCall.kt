package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6InlineProcedureOrArrayCall : VB6AtomicCall {
}

class VB6InlineProcedureOrArrayCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineProcedureOrArrayCall {

    object Factory : IPsiNodeFactory<VB6InlineProcedureOrArrayCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineProcedureOrArrayCall {
            return VB6InlineProcedureOrArrayCallImpl(node)
        }
    }

    override val referenceIdentifier: VB6NamedElement?
        get() = findFirstChildByType(this)
}