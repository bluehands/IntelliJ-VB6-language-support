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

interface VB6InlineVariableOrProcedureCall : VB6AtomicCall {
}

class VB6InlineVariableOrProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6InlineVariableOrProcedureCall {

    object Factory : IPsiNodeFactory<VB6InlineVariableOrProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6InlineVariableOrProcedureCall {
            return VB6InlineVariableOrProcedureCallImpl(node)
        }
    }

    override val referenceIdentifier: VB6Identifier?
        get() = findFirstChildByType(this)


}