package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.language.VB6IElementTypes
import com.github.tyrrx.vb6language.language.VB6Language
import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.base.VB6NamedElement
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiElement
import com.github.tyrrx.vb6language.psi.declarations.VB6TypeDeclaration
import com.github.tyrrx.vb6language.psi.reference.VB6ReferenceOwner
import com.github.tyrrx.vb6language.psi.scope.VB6EnclosingVisibleNamedElements
import com.github.tyrrx.vb6language.psi.scope.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6StringLiteral
import com.github.tyrrx.vb6language.psi.utils.createElementFromText
import com.github.tyrrx.vb6language.psi.utils.findFirstChildByTypeOf
import com.github.tyrrx.vb6language.psi.visitor.NamedElementOwnerVisitor
import com.github.tyrrx.vb6language.psi.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.visitor.TypeDeclarationVisitor
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface VB6Module : VB6ScopeNode, VB6NamedElementOwner, VB6NamedElement, VB6TypeDeclaration {
    // base
    val moduleHeader: VB6ModuleHeader?
    val moduleConfig: VB6ModuleConfig?
    val moduleAttributes: VB6ModuleAttributes?
    val moduleDeclarations: VB6ModuleDeclarations?
    val moduleBody: VB6ModuleBody?

    val nameAttribute: VB6AttributeStmt?

    fun isClass(): Boolean
}

val VB6Module.bodyElements: List<VB6PsiElement>
    get() = moduleBody?.getStatements() ?: emptyList()

val VB6Module.declarationElements: List<VB6PsiElement>
    get() = moduleDeclarations
            ?.elements
            ?.mapNotNull { it.declaration }
            ?.filterNot { it is VB6AttributeStmt }
            ?: emptyList()

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
    override val moduleHeader: VB6ModuleHeader? get() = findFirstChildByTypeOf(this)
    override val moduleConfig: VB6ModuleConfig? get() = findFirstChildByTypeOf(this)
    override val moduleAttributes: VB6ModuleAttributes? get() = findFirstChildByTypeOf(this)
    override val moduleDeclarations: VB6ModuleDeclarations? get() = findFirstChildByTypeOf(this)
    override val moduleBody: VB6ModuleBody? get() = findFirstChildByTypeOf(this)

    override val nameAttribute: VB6AttributeStmt?
        get() = moduleAttributes
                ?.attributes
                ?.firstOrNull { declaration ->
                    declaration.nameIdentifier?.name == "VB_Name"
                }

    override fun <TReturn> accept(nodeVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return nodeVisitor.visitModule(this)
    }

    override fun <TReturn> accept(namedElementOwnerVisitor: NamedElementOwnerVisitor<TReturn>): TReturn {
        return namedElementOwnerVisitor.visitModule(this)
    }

    override fun isClass(): Boolean {
        return moduleHeader?.isClass() ?: false
    }

    override fun setName(name: String): PsiElement {
        val element = createElementFromText(
                project,
                VB6Language.INSTANCE,
                context,
                "\"$name\"",
                VB6IElementTypes.rules[VisualBasic6Parser.RULE_literal]
        )
        element?.let {
            nameAttribute?.literals?.firstOrNull()?.literalElement?.replace(it);
        }
        return this
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

    override val referenceOwner: VB6ReferenceOwner?
        get() = null

    override val namedElementOwner: VB6NamedElementOwner?
        get() = this

    override fun <TReturn> processTypeDeclarations(visitor: TypeDeclarationVisitor<TReturn>): TReturn {
        return visitor.processModuleDeclarations(this)
    }

    override fun getName(): String? {
        return when (val literal = nameAttribute?.literals?.firstOrNull()?.literalElement) {
            is VB6StringLiteral -> literal.value
            else -> null
        }
    }

    override val isDefinition: Boolean
        get() = true

    // return this because a literal cannot be named
    override fun getNameIdentifier(): VB6NamedElement {
        return this
    }

    object Factory : IPsiNodeFactory<VB6Module> {
        override fun createPsiNode(node: ASTNode): VB6ModuleImpl {
            return VB6ModuleImpl(node)
        }
    }
}



