package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Argument
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6ArgumentList
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6PropertySetStatement
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6PropertySetStatementImpl(node: ASTNode) : VB6PsiNode(node),
    VB6PropertySetStatement {

    object Factory : IPsiNodeFactory<VB6PropertySetStatement> {
        override fun createPsiNode(node: ASTNode): VB6PropertySetStatement {
            return VB6PropertySetStatementImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getArguments(): List<VB6Argument> {
        return findFirstChildByType<VB6ArgumentList>(this)
            ?.getArguments() ?: emptyList()
    }

    override fun getName(): String? {
        return nameIdentifier?.name;
    }

    override fun getNameIdentifier(): VB6Identifier? {
        return findFirstChildByType(this)
    }
}