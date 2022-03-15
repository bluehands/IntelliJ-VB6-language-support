package com.github.tyrrx.vb6language.psi.tree.interfaces

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6PsiElement
import com.intellij.lang.ASTNode

interface VB6ValueStmt: VB6PsiElement {
}

class VB6ValueImpl(node: ASTNode) : VB6PsiNode(node), VB6ValueStmt {

    object Factory: IPsiNodeFactory<VB6ValueStmt> {
        override fun createPsiNode(node: ASTNode): VB6ValueStmt {
            return VB6ValueImpl(node)
        }
    }
}