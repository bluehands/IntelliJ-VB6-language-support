package com.github.tyrrx.vb6language.psi.tree.definition.module

import com.github.tyrrx.vb6language.psi.language.IPsiNodeFactory
import com.github.tyrrx.vb6language.psi.tree.visitor.ScopeNodeVisitor
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6IdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6PsiElement
import com.github.tyrrx.vb6language.psi.tree.definition.base.VB6ScopeNode
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6AttributeStmt
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.VB6ConstStmt
import com.github.tyrrx.vb6language.psi.tree.definition.variable.VB6ModuleVariableStmt
import com.github.tyrrx.vb6language.psi.tree.utils.findFirstChildByType
import com.github.tyrrx.vb6language.psi.tree.utils.findPsiElementInSubtree
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface VB6Module : VB6ScopeNode, PsiNameIdentifierOwner {
    // base
    fun getModuleHeader(): VB6ModuleHeader?
    fun getModuleConfig(): VB6ModuleConfig?
    fun getModuleAttributes(): VB6ModuleAttributes?
    fun getModuleDeclarations(): VB6ModuleDeclarations?
    fun getModuleBody(): VB6ModuleBody?

    val definitions: List<VB6IdentifierOwner>
    val bodyDefinitions: List<VB6IdentifierOwner>
    val declarationsDefinitions: List<VB6IdentifierOwner>

    fun isClass(): Boolean
    fun getModuleConfigElements(): Collection<VB6ModuleConfigElement>

    fun getFunctions(): List<VB6FunctionStatement>
    fun getSubroutines(): List<VB6SubroutineStatement>
    fun getProcedureDeclarations(): List<VB6DeclareStmt>

    fun getPropertyGets(): List<VB6PropertyGetStatement>
    fun getPropertySets(): List<VB6PropertySetStatement>
    fun getPropertyLets(): List<VB6PropertyLetStatement>
}


fun VB6Module.fromBodyGetElements(): List<VB6PsiElement> {
    return getModuleBody()?.getStatements() ?: emptyList()
}

fun VB6Module.fromDeclarationsGetElements(): List<VB6PsiElement> {
    return getModuleDeclarations()?.getElements()?.map { it.getInnerElement() } ?: emptyList()
}


inline fun <reified TStatement> VB6Module.fromModuleBodyGetByType(): List<TStatement> {
    return fromBodyGetElements().filterIsInstance<TStatement>()
}

inline fun <reified TStatement> VB6Module.fromModuleDeclarationsGetByType(): List<TStatement> {
    return fromDeclarationsGetElements().filterIsInstance<TStatement>()
}


//
//fun VB6Module.fromDeclarationsGetDeclares(): List<VB6DeclareStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetEnumerations(): List<VB6EnumerationStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetEvents(): List<VB6EventStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetConst(): List<VB6ConstStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetImplements(): List<VB6ImplementsStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetVariables(): List<VB6ModuleVariableDefinition> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetArrayVariables(): List<VB6ModuleVariableDefinition> {
//    return fromDeclarationsGetVariables().filter { it.isArray() }
//}
//
//fun VB6Module.fromDeclarationsGetOptions() {
//    TODO("Not yet implemented")
//}
//
//fun VB6Module.fromDeclarationsGetTypes(): List<VB6TypeStmt> {
//    return fromModuleDeclarationsGetByType()
//}
//
//fun VB6Module.fromDeclarationsGetMacros() {
//    TODO("Not yet implemented")
//}


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

    override val definitions: List<VB6IdentifierOwner>
        get() = bodyDefinitions.plus(declarationsDefinitions)

    override val bodyDefinitions: List<VB6IdentifierOwner>
        get() = fromBodyGetElements().flatMap {
            when(it) {
                is VB6IdentifierOwner -> listOf(it)
                else -> emptyList()
            }
        }

    override val declarationsDefinitions: List<VB6IdentifierOwner>
        get() = fromDeclarationsGetElements().flatMap {
            when(it) {
                is VB6IdentifierOwner -> listOf(it)
                is VB6ConstStmt -> it.declarations
                is VB6ModuleVariableStmt -> it.definitions
                else -> emptyList()
            }
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

    override fun <TReturn> resolve(resolveVisitor: ScopeNodeVisitor<TReturn>): TReturn {
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



