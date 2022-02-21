package com.github.tyrrx.vb6language.psi.tree.nodes

import com.github.tyrrx.vb6language.psi.IPsiNodeFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.ScopeNode

class Module(node: ASTNode) : ANTLRPsiNode(node), ScopeNode {
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return super.getName()
    }

    object Factory : IPsiNodeFactory<Module> {
        override fun createPsiNode(node: ASTNode): Module {
            return Module(node)
        }
    }
}