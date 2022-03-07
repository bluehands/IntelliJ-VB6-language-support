@file:Suppress("ClassName")

package com.github.tyrrx.vb6language.psi.tree.impl.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.impl.VB6ProcedureReference
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6eCS_ProcedureCall
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

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
        return VB6ProcedureReference(this)
    }
}

