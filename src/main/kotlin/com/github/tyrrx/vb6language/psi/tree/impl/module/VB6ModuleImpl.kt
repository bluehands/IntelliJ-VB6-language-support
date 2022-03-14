package com.github.tyrrx.vb6language.psi.tree.impl.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.reference.visitor.ReferenceResolveVisitor
import com.github.tyrrx.vb6language.psi.tree.impl.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.interfaces.module.*
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6ModuleVariableDefinition
import com.github.tyrrx.vb6language.psi.tree.interfaces.variable.VB6ModuleVariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementsInDirectChildrenByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

class VB6ModuleImpl(node: ASTNode) : VB6PsiNode(node), VB6Module {
    override fun getModuleHeader(): VB6ModuleHeader? {
        return findFirstChildByType(this)
    }

    override fun getModuleConfig(): VB6ModuleConfig? {
        return findFirstChildByType(this)
    }

    override fun getModuleAttributes(): VB6ModuleAttributes? {
        return findFirstChildByType(this)
    }

    override fun getModuleDeclarations(): VB6ModuleDeclarations? {
        return findFirstChildByType(this)
    }

    override fun getModuleBody(): VB6ModuleBody? {
        return findFirstChildByType(this)
    }

    //-----------------------------------------

    override fun getFunctions(): List<VB6FunctionStatement> {
        return fromModuleBodyGetByType()
    }

    override fun getSubroutines(): List<VB6SubroutineStatement> {
        return fromModuleBodyGetByType()
    }

    override fun getProcedureDeclarations(): List<VB6DeclareStmt> {
        return fromModuleDeclarationsGetByType()
    }

    override fun getPropertyGets(): List<VB6PropertyGetStatement> {
        return fromModuleBodyGetByType()
    }

    override fun getPropertySets(): List<VB6PropertySetStatement> {
        return fromModuleBodyGetByType()
    }

    override fun getPropertyLets(): List<VB6PropertyLetStatement> {
        return fromModuleBodyGetByType()
    }

    override fun resolve(resolveVisitor: ReferenceResolveVisitor): VB6IdentifierOwner? {
        return resolveVisitor.resolveModule(this)
    }


    override fun isClass(): Boolean {
        return getModuleHeader()?.isClass() ?: false
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

    override fun getNameIdentifier(): VB6AttributeStmt? {
        return getModuleAttributes()
            ?.getAttributes()
            ?.firstOrNull { declaration ->
            declaration.nameIdentifier?.name == "VB_Name"
        }
    }

    object Factory : IPsiNodeFactory<VB6Module> {
        override fun createPsiNode(node: ASTNode): VB6ModuleImpl {
            return VB6ModuleImpl(node)
        }
    }
}