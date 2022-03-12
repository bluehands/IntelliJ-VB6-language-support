package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.VB6Attribute
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.*
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleImpl(node: ASTNode) : VB6PsiNode(node), VB6Module {
    override fun getModuleAttributes(): Collection<VB6Attribute> {
        return findPsiElementsInSubtree(this)
    }

    override fun getFunctions(): List<VB6FunctionStatement> {
        return getModuleBodyStatementsByType()
    }

    override fun getSubroutines(): List<VB6SubroutineStatement> {
        return getModuleBodyStatementsByType()
    }

    override fun getPropertyGets(): List<VB6PropertyGetStatement> {
        return getModuleBodyStatementsByType()
    }

    override fun getPropertySets(): List<VB6PropertySetStatement> {
        return getModuleBodyStatementsByType()
    }

    override fun getPropertyLets(): List<VB6PropertyLetStatement> {
        return getModuleBodyStatementsByType()
    }

    override fun getBodyStatements(): List<PsiElement> {
        return getModuleBody()?.getStatements()?: emptyList()
    }

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveModule(this)
    }

    override fun getModuleBody(): VB6ModuleBody? {
        return findFirstChildByType(this)
    }

    override fun getModuleHeaders(): Collection<VB6ModuleHeader> {
        return findPsiElementsInSubtree(this)
    }

    override fun isClass(): Boolean {
        return getModuleHeaders().firstOrNull()?.isClass() ?: false
    }

    override fun getModuleConfigElements(): Collection<VB6ModuleConfigElement> {
        return findPsiElementInSubtree<VB6ModuleConfig>(this)
            ?.getModuleConfigElements() ?: emptyList()
    }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return nameIdentifier?.getLiterals()?.firstOrNull()?.getLiteralElement()?.text
    }

    override fun getNameIdentifier(): VB6Attribute? {
        return getModuleAttributes().firstOrNull { declaration ->
            declaration.nameIdentifier?.text.equals("VB_Name")
        }
    }

    object Factory : IPsiNodeFactory<VB6Module> {
        override fun createPsiNode(node: ASTNode): VB6ModuleImpl {
            return VB6ModuleImpl(node)
        }
    }

    private inline fun <reified TStatement> getModuleBodyStatementsByType(): List<TStatement> {
        return getModuleBody()
            ?.getStatements()
            ?.filterIsInstance<TStatement>() ?: emptyList()
    }
}