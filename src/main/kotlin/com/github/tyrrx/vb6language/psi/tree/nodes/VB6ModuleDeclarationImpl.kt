package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6AttributeDeclaration
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleDeclaration
import com.github.tyrrx.vb6language.psi.tree.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode

class VB6ModuleDeclarationImpl(node: ASTNode) : VB6PsiNode(node), VB6ModuleDeclaration {
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
        return findPsiElementsInSubtree<VB6AttributeDeclaration>(this).firstOrNull { declaration ->
            declaration.nameIdentifier?.text.equals("VB_Name")
        } // TODO or use file name?
    }

    object Factory : IPsiNodeFactory<VB6ModuleDeclaration> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarationImpl {
            return VB6ModuleDeclarationImpl(node)
        }
    }
}