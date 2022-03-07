package com.github.tyrrx.vb6language.psi.tree.impl

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ScopeNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import org.antlr.intellij.adaptor.psi.Trees


open class VB6PsiNode(node: ASTNode) : ASTWrapperPsiElement(node) {

    /** For some reason, default impl of this only returns rule refs
     * (composite nodes in jetbrains speak) but we want ALL children.
     * Well, we don't want hidden channel stuff.
     */
    override fun getChildren(): Array<PsiElement> {
        return Trees.getChildren(this)
    }
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
