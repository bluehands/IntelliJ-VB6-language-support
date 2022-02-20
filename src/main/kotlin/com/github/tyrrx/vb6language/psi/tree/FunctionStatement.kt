package com.github.tyrrx.vb6language.psi.tree

import com.github.tyrrx.vb6language.VisualBasic6Language
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ui.tree.TreeUtil
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode
import kotlin.reflect.typeOf

class FunctionStatement(node: ASTNode) : ANTLRPsiNode(node), ScopeNode, PsiNameIdentifierOwner {

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(
            this, VisualBasic6Language.INSTANCE,
            element, "/ambiguousIdentifier/IDENTIFIER"
        )
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return PsiTreeUtil.findChildOfType(this, IdentifierPsiLeaf::class.java)
    }
}