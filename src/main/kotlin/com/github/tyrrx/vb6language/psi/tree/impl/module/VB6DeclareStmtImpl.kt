package com.github.tyrrx.vb6language.psi.tree.impl.module


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6DeclareStmt
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6DeclareStmtImpl(node: ASTNode) : VB6PsiNode(node), VB6DeclareStmt {

    object Factory : IPsiNodeFactory<VB6DeclareStmt> {
        override fun createPsiNode(node: ASTNode): VB6DeclareStmt {
            return VB6DeclareStmtImpl(node)
        }
    }

    override fun getNameIdentifier(): VB6Identifier? {
        TODO("Not yet implemented")
    }


    override fun getName(): String? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}