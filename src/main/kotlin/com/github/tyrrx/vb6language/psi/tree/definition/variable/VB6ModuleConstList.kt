package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleConstList : VB6PsiElement {
    val declarations: List<VB6ModuleConst>
    val visibility: VB6Visibility?
}

class VB6ModuleConstListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConstList {

    object Factory : IPsiNodeFactory<VB6ConstList> {
        override fun createPsiNode(node: ASTNode): VB6ConstList {
            return VB6ConstListImpl(node)
        }
    }

    override val declarations: List<VB6ModuleConst>
        get() = findPsiElementsInDirectChildrenByType(this)

    override val visibility: VB6Visibility?
        get() = findFirstChildByType(this)
}
