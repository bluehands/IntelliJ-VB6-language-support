package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.utils.findChildElementsByTypeOf
import com.intellij.lang.ASTNode

interface VB6ConstList : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val declarations: List<VB6BlockConst>
}

class VB6ConstListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ConstList {

    object Factory : IPsiNodeFactory<VB6ConstList> {
        override fun createPsiNode(node: ASTNode): VB6ConstList {
            return VB6ConstListImpl(node)
        }
    }

    override val declarations: List<VB6BlockConst>
        get() = findChildElementsByTypeOf(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = declarations

}
