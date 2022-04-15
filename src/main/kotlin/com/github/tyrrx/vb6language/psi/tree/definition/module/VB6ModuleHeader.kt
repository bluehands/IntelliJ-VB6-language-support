package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

interface VB6ModuleHeader: PsiElement {
    fun getVersion(): Double
    fun isClass(): Boolean
}

class VB6ModuleHeaderImpl(node: ASTNode) : VB6PsiNode(node),
    VB6ModuleHeader {

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