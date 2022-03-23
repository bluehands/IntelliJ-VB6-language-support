package com.github.tyrrx.vb6language.psi.tree.definition.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.SymbolReference
import com.github.tyrrx.vb6language.psi.reference.VB6Reference
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode

interface VB6ExplicitProcedureCall : VB6ReferenceOwner, VB6ReferenceFactory {

}

class VB6ExplicitProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6ExplicitProcedureCall {

    object Factory : IPsiNodeFactory<VB6ExplicitProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6ExplicitProcedureCall {
            return VB6ExplicitProcedureCallImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        val referencingIdentifier =
            findFirstChildByType<VB6Identifier>(this)
        return referencingIdentifier
            ?.let { SymbolReference(this, it, it.textRangeInParent) }
    }

    override fun getReference(): VB6Reference? {
        return createReference()
    }
}

