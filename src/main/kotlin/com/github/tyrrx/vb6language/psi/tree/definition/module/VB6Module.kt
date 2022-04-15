package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.inference.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.scope.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6StringLiteral
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Module : VB6ScopeNode, VB6NamedElementOwner, VB6TypeDeclaration {
    // base
    val moduleHeader: VB6ModuleHeader?
    val moduleConfig: VB6ModuleConfig?
    val moduleAttributes: VB6ModuleAttributes?
    val moduleDeclarations: VB6ModuleDeclarations?
    val moduleBody: VB6ModuleBody?

    fun isClass(): Boolean
}

val VB6Module.bodyElements: List<VB6PsiElement>
    get() = moduleBody?.getStatements() ?: emptyList()

val VB6Module.declarationElements: List<VB6PsiElement>
    get() = moduleDeclarations?.elements?.mapNotNull { it.declaration } ?: emptyList()

val VB6Module.moduleElements: List<VB6PsiElement>
    get() = bodyElements + declarationElements

val VB6Module.namedElementOwners: List<VB6NamedElementOwner>
    get() = moduleElements
        .filterIsInstance<VB6EnclosingVisibleNamedElements>()
        .flatMap { it.outsideVisibleNamedElementOwners }

//inline fun <reified TStatement> VB6Module.fromModuleBodyGetByType(): List<TStatement> {
//    return fromBodyGetElements().filterIsInstance<TStatement>()
//}
//
//inline fun <reified TStatement> VB6Module.fromModuleDeclarationsGetByType(): List<TStatement> {
//    return fromDeclarationsGetElements().filterIsInstance<TStatement>()
//}


class VB6ModuleImpl(node: ASTNode) : VB6PsiNode(node), VB6Module {
    override val moduleHeader: VB6ModuleHeader? get() = findFirstChildByType(this)
    override val moduleConfig: VB6ModuleConfig? get() = findFirstChildByType(this)
    override val moduleAttributes: VB6ModuleAttributes? get() = findFirstChildByType(this)
    override val moduleDeclarations: VB6ModuleDeclarations? get() = findFirstChildByType(this)
    override val moduleBody: VB6ModuleBody? get() = findFirstChildByType(this)

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveModule(this)
    }

    override fun isClass(): Boolean {
        return moduleHeader?.isClass() ?: false
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val outsideVisibleNamedElementOwners: List<VB6NamedElementOwner>
        get() = namedElementOwners
            .filterIsInstance<VB6VisibilityOwner>()
            .filter {
                when (it.visibility) {
                    VB6VisibilityEnum.PRIVATE -> false
                    VB6VisibilityEnum.PUBLIC -> true
                    VB6VisibilityEnum.FRIEND -> true
                    VB6VisibilityEnum.GLOBAL -> true
                }
            }
            .flatMap { it.outsideVisibleNamedElementOwners } // todo dangerous exposing of inner elements when visible

    override val outsideVisibleNamedElements: List<VB6NamedElement>
        get() = emptyList()

    override fun <TReturn> processTypeDeclarations(visitor: TypeDeclarationVisitor<TReturn>): TReturn {
        return visitor.processModuleDeclarations(this)
    }

    override fun getName(): String? {
        return when (val literal = nameIdentifier?.literals?.firstOrNull()?.literalElement) {
            is VB6StringLiteral -> literal.value
            else -> null
        }
    }

    override val isDefinition: Boolean
        get() = true

    override fun getNameIdentifier(): VB6AttributeStmt? {
        return moduleAttributes
            ?.attributes
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



