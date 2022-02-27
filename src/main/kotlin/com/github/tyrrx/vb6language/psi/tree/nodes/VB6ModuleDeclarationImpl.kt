package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6ModuleDeclaration
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode

class VB6ModuleDeclarationImpl(node: ASTNode) : ANTLRPsiNode(node), VB6ModuleDeclaration {
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        TODO("Not yet implemented")
    }

    object Factory : IPsiNodeFactory<VB6ModuleDeclarationImpl> {
        override fun createPsiNode(node: ASTNode): VB6ModuleDeclarationImpl {
            return VB6ModuleDeclarationImpl(node)
        }
    }
}