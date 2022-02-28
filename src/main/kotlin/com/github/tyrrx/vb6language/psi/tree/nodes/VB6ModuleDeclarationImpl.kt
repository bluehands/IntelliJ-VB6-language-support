package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6AttributeDeclaration
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleDeclaration
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleHeader
import com.github.tyrrx.vb6language.psi.tree.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode

class VB6ModuleDeclarationImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclaration {
    override fun getModuleAttributes(): Collection<VB6AttributeDeclaration> {
        return findPsiElementsInSubtree(this)
    }

    override fun getModuleHeaders(): Collection<VB6ModuleHeader> {
        return findPsiElementsInSubtree(this)
    }

    override fun isClass(): Boolean {
        return getModuleHeaders().firstOrNull()?.isClass() ?: false
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

    override fun getNameIdentifier(): VB6AttributeDeclaration? {
        return getModuleAttributes().firstOrNull { declaration ->
            declaration.nameIdentifier?.text.equals("VB_Name")
        } // TODO or use file name?
    }

    object Factory : IPsiNodeFactory<VB6ModuleDeclaration> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarationImpl {
            return VB6ModuleDeclarationImpl(node)
        }
    }
}