@file:Suppress("ClassName")

package com.github.tyrrx.vb6language.psi.tree.impl.call

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.call.VB6eCS_ProcedureCall
import com.github.tyrrx.vb6language.psi.tree.interfaces.identifier.VB6Identifier
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.VB6Module
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import org.antlr.intellij.adaptor.psi.ScopeNode

class VB6eCS_ProcedureCallImpl(node: ASTNode) : VB6PsiNode(node), VB6eCS_ProcedureCall {

    object Factory : IPsiNodeFactory<VB6eCS_ProcedureCall> {
        override fun createPsiNode(node: ASTNode): VB6eCS_ProcedureCall {
            return VB6eCS_ProcedureCallImpl(node)
        }
    }

    override fun getReference(): PsiReference {
        val source = findFirstChildByType<VB6Identifier>(this)
        return TestReference(source!!)
    }
}

class TestReference(private val myElement: PsiNamedElement) : PsiReference {
    override fun getElement(): PsiElement {
        return myElement
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, myElement.text.length)
    }

    override fun resolve(): PsiElement? {
        val scopeNode = myElement.context as ScopeNode?
        val resolve = scopeNode?.resolve(myElement)
        return resolve
    }

    override fun getCanonicalText(): String {
        return element.text
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.setName(newElementName);
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val name = myElement.name
        if (element is PsiNamedElement) {
            val otherName = element.name
            return otherName == name
        }
        return false
    }

    override fun isSoft(): Boolean {
        return false
    }
}