package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6Visibility
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
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

}
