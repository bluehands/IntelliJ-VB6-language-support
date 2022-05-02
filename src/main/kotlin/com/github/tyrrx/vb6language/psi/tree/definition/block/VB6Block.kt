package com.github.tyrrx.vb6language.psi.tree.definition.block

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6Block : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val statements: List<VB6PsiElement>
}

class VB6BlockImpl(node: ASTNode) : VB6PsiNode(node), VB6Block {

    object Factory : IPsiNodeFactory<VB6Block> {
        override fun createPsiNode(node: ASTNode): VB6Block {
            return VB6BlockImpl(node)
        }
    }

    override val statements: List<VB6PsiElement>
        get() = findChildElementsByTypeOf<VB6BlockStmt>(this)
            .mapNotNull { it.statement }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = statements
            .filterIsInstance<VB6EnclosingVisibleNamedElements>()
            .flatMap { it.outsideVisibleNamedElementOwners }

}
