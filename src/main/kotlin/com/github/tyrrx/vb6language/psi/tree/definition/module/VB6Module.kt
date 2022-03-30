package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.definition.base.*
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.general.VB6VisibilityEnum
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6StringLiteral
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ModuleConstList
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ModuleVariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Module : VB6ScopeNode, PsiNameIdentifierOwner {
    // base
    val moduleHeader: VB6ModuleHeader?
    val moduleConfig: VB6ModuleConfig?
    val moduleAttributes: VB6ModuleAttributes?
    val moduleDeclarations: VB6ModuleDeclarations?
    val moduleBody: VB6ModuleBody?

    val definitions: List<VB6NamedElementOwner>
    val bodyDefinitions: List<VB6NamedElementOwner>
    val declarationsDefinitions: List<VB6NamedElementOwner>
    val projectVisibleDefinitions: List<VB6NamedElementOwner>

    fun isClass(): Boolean
}

fun VB6Module.fromBodyGetElements(): List<VB6PsiElement> {
    return moduleBody?.getStatements() ?: emptyList()
}

fun VB6Module.fromDeclarationsGetElements(): List<VB6PsiElement> {
    return moduleDeclarations?.elements?.mapNotNull { it.declaration } ?: emptyList()
}

inline fun <reified TStatement> VB6Module.fromModuleBodyGetByType(): List<TStatement> {
    return fromBodyGetElements().filterIsInstance<TStatement>()
}

inline fun <reified TStatement> VB6Module.fromModuleDeclarationsGetByType(): List<TStatement> {
    return fromDeclarationsGetElements().filterIsInstance<TStatement>()
}


class VB6ModuleImpl(node: ASTNode) : VB6PsiNode(node), VB6Module {
    override val moduleHeader: VB6ModuleHeader? = findFirstChildByType(this)
    override val moduleConfig: VB6ModuleConfig? = findFirstChildByType(this)
    override val moduleAttributes: VB6ModuleAttributes? = findFirstChildByType(this)
    override val moduleDeclarations: VB6ModuleDeclarations? = findFirstChildByType(this)
    override val moduleBody: VB6ModuleBody? = findFirstChildByType(this)

    override val definitions: List<VB6NamedElementOwner> get() = bodyDefinitions + declarationsDefinitions

    override val bodyDefinitions: List<VB6NamedElementOwner>
        get() = fromBodyGetElements().flatMap {
            when (it) {
                is VB6PropertyStatementBase -> listOf(it)
                is VB6FunctionStatement -> listOf(it)
                is VB6SubroutineStatement -> listOf(it)
                else -> emptyList()
            }
        }

    override val declarationsDefinitions: List<VB6NamedElementOwner>
        get() = fromDeclarationsGetElements()
            .flatMap {
                when (it) {
                    is VB6DeclareStmt -> listOf(it)
                    is VB6EnumerationStmt -> listOf(it)
                    is VB6EventStmt -> listOf(it)
                    is VB6ModuleConstList -> it.declarations
                    is VB6ModuleVariableStmt -> it.definitions
                    is VB6TypeStmt -> listOf(it)
                    else -> emptyList()
                }
            }

    override val projectVisibleDefinitions: List<VB6NamedElementOwner>
        get() = definitions
            .filterIsInstance<VB6VisibilityOwner>()
            .filter {
                when (it.visibility) {
                    VB6VisibilityEnum.PUBLIC -> true
                    VB6VisibilityEnum.FRIEND -> true
                    else -> false
                }
            }

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
        return resolveVisitor.resolveModule(this)
    }

    override fun isClass(): Boolean {
        return moduleHeader?.isClass() ?: false
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? {
        return when(val literal = nameIdentifier?.literals?.firstOrNull()?.literalElement) {
            is VB6StringLiteral -> literal.value
            else -> null
        }
    }

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



