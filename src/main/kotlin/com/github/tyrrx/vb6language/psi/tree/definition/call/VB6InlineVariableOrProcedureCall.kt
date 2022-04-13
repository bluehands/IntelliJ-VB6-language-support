package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6InlineVariableOrProcedureCall : VB6AtomicCall {
}

class VB6InlineVariableOrProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineVariableOrProcedureCall {

    object Factory : IPsiNodeFactory<VB6InlineVariableOrProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineVariableOrProcedureCall {
            return VB6InlineVariableOrProcedureCallImpl(node)
        }
    }

    override val referenceIdentifier: VB6NamedElement?
        get() = findFirstChildByType(this)

}