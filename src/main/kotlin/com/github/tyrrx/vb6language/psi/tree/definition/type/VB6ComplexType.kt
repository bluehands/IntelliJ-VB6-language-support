package com.github.tyrrx.vb6language.psi.tree.definition.type

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode

interface VB6ComplexType: VB6TypeElement {
    val identifiers: List<VB6Identifier>
}

class VB6ComplexTypeImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ComplexType {

    object Factory : IPsiNodeFactory<VB6ComplexType> {
        override fun createPsiNode(node: ASTNode): VB6ComplexType {
            return VB6ComplexTypeImpl(node)
        }
    }

    override val identifiers: List<VB6Identifier>
        get() = findPsiElementsInDirectChildrenByType(this)
}