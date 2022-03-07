package com.github.tyrrx.vb6language.psi.tree.impl.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6iCS_S_MembersCall
import com.intellij.lang.ASTNode

class VB6iCS_S_MembersCallImpl(node: ASTNode) : VB6PsiNode(node), VB6iCS_S_MembersCall {

    object Factory : IPsiNodeFactory<VB6iCS_S_MembersCall> {
        override fun createPsiNode(node: ASTNode): VB6iCS_S_MembersCall {
            return VB6iCS_S_MembersCallImpl(node)
        }
    }
}