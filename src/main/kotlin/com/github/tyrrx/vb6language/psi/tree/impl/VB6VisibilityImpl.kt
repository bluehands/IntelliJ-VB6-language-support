package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Visibility
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6VisibilityEnum
import com.intellij.lang.ASTNode
import com.intellij.psi.util.elementType

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