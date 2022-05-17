package com.github.tyrrx.vb6language.psi.tree.definition.general

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.util.elementType

interface VB6Visibility: VB6PsiElement {
    fun getEnumValue(): VB6VisibilityEnum
}

class VB6VisibilityImpl(node: ASTNode) : VB6PsiNode(node),
    VB6Visibility {

    override fun getEnumValue(): VB6VisibilityEnum {
        return when (firstChild.elementType) {
            VB6IElementTypes.PRIVATE -> VB6VisibilityEnum.PRIVATE
            VB6IElementTypes.FRIEND -> VB6VisibilityEnum.FRIEND
            VB6IElementTypes.GLOBAL -> VB6VisibilityEnum.GLOBAL
            VB6IElementTypes.PUBLIC -> VB6VisibilityEnum.PUBLIC
            else -> throw NotImplementedError("ElementType in enum type not supported")
        }
    }

    object Factory: IPsiNodeFactory<VB6Visibility> {
        override fun createPsiNode(node: ASTNode): VB6Visibility {
            return VB6VisibilityImpl(node)
        }
    }
}