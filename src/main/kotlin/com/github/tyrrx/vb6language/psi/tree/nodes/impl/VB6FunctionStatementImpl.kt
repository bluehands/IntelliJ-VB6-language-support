package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AmbiguousIdentifier
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6FunctionStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6FunctionStatementImpl(node: ASTNode) : VB6PsiNode(node), VB6FunctionStatement {

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
        return findFirstChildByType(this)
    }

    override fun getArguments(): List<VB6Argument> {
        return findFirstChildByType<VB6ArgumentListImpl>(this)
            ?.getArguments() ?: emptyList()
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