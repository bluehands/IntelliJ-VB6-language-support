package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.VB6Attribute
import com.github.tyrrx.vb6language.psi.tree.VB6Literal
import com.github.tyrrx.vb6language.psi.tree.findIdentifierInSubtree
import com.github.tyrrx.vb6language.psi.tree.findLiteralsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6AttributeImpl(node: ASTNode) : VB6PsiNode(node), VB6Attribute {

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getLiterals(): Collection<VB6Literal> {
        return findLiteralsInSubtree(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.findIdentifierInSubtree()
    }

    object Factory : IPsiNodeFactory<VB6Attribute>{
        override fun createPsiNode(node: ASTNode): VB6Attribute {
            return VB6AttributeImpl(node)
        }
    }
}