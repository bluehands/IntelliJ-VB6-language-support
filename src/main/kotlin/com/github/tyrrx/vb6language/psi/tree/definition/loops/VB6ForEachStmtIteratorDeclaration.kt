package com.github.tyrrx.vb6language.psi.tree.definition.loops

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceFactory
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.reference.references.CallOrValueReference
import com.github.tyrrx.vb6language.psi.reference.references.VB6Reference
import com.github.tyrrx.vb6language.psi.scope.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.utils.findFirstParentOfType
import com.intellij.lang.ASTNode

interface VB6ForEachStmtIteratorDeclaration :
        VB6ReferenceOwner, VB6ReferenceFactory {
    val identifier: VB6NamedElement?
}

class VB6ForEachStmtIteratorDeclarationImpl(node: ASTNode) : VB6PsiNode(node), VB6ForEachStmtIteratorDeclaration {

    object Factory : IPsiNodeFactory<VB6ForEachStmtIteratorDeclaration> {
        override fun createPsiNode(node: ASTNode): VB6ForEachStmtIteratorDeclaration {
            return VB6ForEachStmtIteratorDeclarationImpl(node)
        }
    }

    override val referenceFactory: VB6ReferenceFactory
        get() = this

    override fun createReference(): VB6Reference? {
        return identifier?.let {
            return CallOrValueReference(this, it, it.textRangeInParent)
        }
    }

    override val identifier: VB6NamedElement?
        get() = findFirstChildByTypeOf(this)

    override fun getReference(): VB6Reference? {
        return createReference()
    }

    override fun getContext(): VB6ScopeNode? {
        return findFirstParentOfType<VB6ForEachStmt>(this)?.context
    }

}

