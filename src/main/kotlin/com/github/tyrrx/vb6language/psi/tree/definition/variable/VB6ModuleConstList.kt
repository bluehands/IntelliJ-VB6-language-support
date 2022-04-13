package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ModuleConstList : VB6PsiElement, VB6EnclosingVisibleNamedElements {
    val constDefinitions: List<VB6ModuleConst>
    val visibility: VB6Visibility?
}

class VB6ModuleConstListImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleConstList {

    object Factory : IPsiNodeFactory<VB6ModuleConstList> {
        override fun createPsiNode(node: ASTNode): VB6ModuleConstList {
            return VB6ModuleConstListImpl(node)
        }
    }

    override val constDefinitions: List<VB6ModuleConst>
        get() = findPsiElementsInDirectChildrenByType<VB6ConstStmt>(this)

    override val visibility: VB6Visibility?
        get() = findFirstChildByType(this)

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = constDefinitions

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList() // todo also this?

}
