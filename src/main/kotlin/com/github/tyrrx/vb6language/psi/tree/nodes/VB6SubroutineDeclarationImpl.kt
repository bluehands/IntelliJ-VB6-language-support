package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6SubroutineDeclaration
import com.github.tyrrx.vb6language.psi.tree.findIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode

class VB6SubroutineDeclarationImpl(node: ASTNode) : VB6PsiNode(node), VB6SubroutineDeclaration {
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(
            this, VB6Language.INSTANCE,
            element, "/ambiguousIdentifier/IDENTIFIER"
        )
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return findIdentifierInSubtree(this)
    }

    object Factory : IPsiNodeFactory<VB6SubroutineDeclarationImpl> {
        override fun createPsiNode(node: ASTNode): VB6SubroutineDeclarationImpl {
            return VB6SubroutineDeclarationImpl(node)
        }
    }
}