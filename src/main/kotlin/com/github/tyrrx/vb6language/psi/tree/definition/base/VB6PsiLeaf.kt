package com.github.tyrrx.vb6language.psi.tree.definition.base

import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ScopeNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode

open class VB6PsiLeaf(type: IElementType?, text: CharSequence?) : ANTLRPsiLeafNode(type, text) {
    override fun getContext(): VB6ScopeNode? {
        val parent: PsiElement = this.parent
        if (parent is VB6ScopeNode) {
            return parent
        }
        return if (parent is PsiErrorElement) {
            null
        } else parent.context as VB6ScopeNode?
    }
}