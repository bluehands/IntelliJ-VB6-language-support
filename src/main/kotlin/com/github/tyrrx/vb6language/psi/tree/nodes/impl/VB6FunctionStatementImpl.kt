package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils

class VB6FunctionStatementImpl(node: ASTNode) : VB6PsiNode(node), VB6FunctionStatement {

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): IdentifierPsiLeaf? {
        return findIdentifierInSubtree(this)
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
//        return SymtabUtils.resolve(
//            this, VB6Language.INSTANCE,
//            element, "/ambiguousIdentifier/IDENTIFIER"
//        )
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    object Factory : IPsiNodeFactory<VB6FunctionStatementImpl> {
        override fun createPsiNode(node: ASTNode): VB6FunctionStatementImpl {
            return VB6FunctionStatementImpl(node)
        }
    }
}