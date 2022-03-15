package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6Statement
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6Identifier
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6DeclareStmt : VB6Statement, VB6IdentifierOwner{
}

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