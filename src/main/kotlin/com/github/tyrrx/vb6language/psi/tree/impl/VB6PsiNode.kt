package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode


open class VB6PsiNode(node: ASTNode) : ANTLRPsiNode(node) {
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
