package com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional


import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.block.VB6Block
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.conditional.VB6IfBlockStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.tryResolveInBlockScopeOrParentContext
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement

class VB6IfBlockStmtImpl(node: ASTNode) : VB6PsiNode(node),
    VB6IfBlockStmt {

    object Factory : IPsiNodeFactory<VB6IfBlockStmt> {
        override fun createPsiNode(node: ASTNode): VB6IfBlockStmt {
            return VB6IfBlockStmtImpl(node)
        }
    }

    override fun getBlock(): VB6Block? {
        return findFirstChildByType(this)
    }

    override fun resolve(element: PsiNamedElement?): VB6IdentifierOwner? {
        return tryResolveInBlockScopeOrParentContext(this, element)
    }
}