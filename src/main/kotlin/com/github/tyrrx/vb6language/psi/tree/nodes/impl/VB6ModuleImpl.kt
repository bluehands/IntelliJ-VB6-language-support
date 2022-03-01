package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.*
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6ModuleImpl(node: ASTNode) : VB6PsiNode(node), VB6Module {
    override fun getModuleAttributes(): Collection<VB6Attribute> {
        return findPsiElementsInSubtree(this)
    }

    override fun getFunctions(): Collection<VB6Function> {
        return findPsiElementsInSubtree(this)
    }

    override fun getSubroutines(): Collection<VB6Subroutine> {
        return findPsiElementsInSubtree(this)
    }

    override fun getModuleHeaders(): Collection<VB6ModuleHeader> {
        return findPsiElementsInSubtree(this)
    }

    override fun isClass(): Boolean {
        return getModuleHeaders().firstOrNull()?.isClass() ?: false
    }

    override fun getModuleConfigElements(): Collection<VB6ModuleConfigElement> {
        return findPsiElementInSubtree<VB6ModuleConfig>(this)?.getModuleConfigElements() ?: emptyList()
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.getLiterals()?.firstOrNull()?.getLiteralElement()?.text
    }

    override fun getNameIdentifier(): VB6Attribute? {
        return getModuleAttributes().firstOrNull { declaration ->
            declaration.nameIdentifier?.text.equals("VB_Name")
        } // TODO or use file name?
    }

    object Factory : IPsiNodeFactory<VB6Module> {
        override fun createPsiNode(node: ASTNode): VB6ModuleImpl {
            return VB6ModuleImpl(node)
        }
    }
}