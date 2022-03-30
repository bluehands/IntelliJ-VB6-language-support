package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.intellij.lang.ASTNode

interface VB6TypeStmtMember : VB6PsiElement {
}

class VB6TypeStmtMemberImpl(node: ASTNode) : VB6PsiNode(node), VB6TypeStmtMember {

    object Factory : IPsiNodeFactory<VB6TypeStmtMember> {
        override fun createPsiNode(node: ASTNode): VB6TypeStmtMember {
            return VB6TypeStmtMemberImpl(node)
        }
    }
}