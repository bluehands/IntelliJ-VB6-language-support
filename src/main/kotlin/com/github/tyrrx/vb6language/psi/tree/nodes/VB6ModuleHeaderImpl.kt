package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleHeader
import com.intellij.lang.ASTNode
import com.intellij.psi.util.elementType

class VB6ModuleHeaderImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleHeader {

    override fun getVersion(): Double {
        return children[2].text.toDouble()
    }

    override fun isClass(): Boolean {
        return lastChild.elementType == VB6IElementTypes.CLASS
    }

    object Factory: IPsiNodeFactory<VB6ModuleHeader> {
        override fun createPsiNode(node: ASTNode): VB6ModuleHeader {
            return VB6ModuleHeaderImpl(node)
        }
    }
}