package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfElseIfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveInBlockScopeOrParentContext
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6IfElseIfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfElseIfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfElseIfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfElseIfBlockStmt {
            return VB6IfElseIfBlockStmtImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(element: PsiNamedElement?): VB6IdentifierOwner? {
        return tryResolveInBlockScopeOrParentContext(this, element)
    }
}