package com.github.tyrrx.vb6language.psi.tree.nodes.impl

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.leafes.IdentifierPsiLeaf
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6PropertyGetStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.interfaces.VB6PropertyLetStatement
import com.github.tyrrx.vb6language.psi.tree.nodes.utils.findIdentifierInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6PropertyLetStatementImpl(node: ASTNode) : VB6PsiNode(node), VB6PropertyLetStatement {

    object Factory : IPsiNodeFactory<VB6PropertyLetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertyLetStatement {
            return VB6PropertyLetStatementImpl(node)
        }
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): IdentifierPsiLeaf? {
        return findIdentifierInSubtree()
    }
}