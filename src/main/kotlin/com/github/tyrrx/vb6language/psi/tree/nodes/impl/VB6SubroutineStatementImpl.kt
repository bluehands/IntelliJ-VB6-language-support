package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.VB6Language
import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6AmbiguousIdentifier
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6Block
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6SubroutineStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils

class VB6SubroutineStatementImpl(node: ASTNode) : VB6PsiNode(node), VB6SubroutineStatement {
    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

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
        return nameIdentifier?.name
    }

    override fun getNameIdentifier(): VB6AmbiguousIdentifier? {
        return findFirstChildByType(this)
    }

    object Factory : IPsiNodeFactory<VB6SubroutineStatementImpl> {
        override fun createPsiNode(node: ASTNode): VB6SubroutineStatementImpl {
            return VB6SubroutineStatementImpl(node)
        }
    }
}