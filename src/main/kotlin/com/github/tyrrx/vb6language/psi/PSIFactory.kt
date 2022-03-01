package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.nodes.impl.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

@Suppress("DuplicatedCode")
object PSIFactory {

	private val logger = Logger.getInstance(PSIFactory::class.java)

	fun createElement(node: ASTNode): PsiElement {
		val elementType = node.elementType
		return if (elementType is RuleIElementType) {
			when (elementType.ruleIndex) {
				VisualBasic6Parser.RULE_functionStmt -> VB6FunctionImpl.Factory
				VisualBasic6Parser.RULE_subStmt -> VB6SubroutineImpl.Factory
				VisualBasic6Parser.RULE_module -> VB6ModuleImpl.Factory
				VisualBasic6Parser.RULE_declareStmt -> Declare.Factory
				VisualBasic6Parser.RULE_literal -> VB6LiteralImpl.Factory
				VisualBasic6Parser.RULE_attributeStmt -> VB6AttributeImpl.Factory
				VisualBasic6Parser.RULE_moduleHeader -> VB6ModuleHeaderImpl.Factory
				VisualBasic6Parser.RULE_moduleConfigElement -> VB6ModuleConfigElementImpl.Factory
				VisualBasic6Parser.RULE_moduleConfig -> VB6ModuleConfigImpl.Factory
				VisualBasic6Parser.RULE_visibility -> VB6VisibilityImpl.Factory
				else -> object : IPsiNodeFactory<PsiElement> {
					override fun createPsiNode(node: ASTNode): PsiElement {
						return ANTLRPsiNode(node)
					}
				}
			}.createPsiNode(node)
		} else {
			ANTLRPsiNode(node)
		}
	}

//    private fun mergeAll(vararg maps: Map<IElementType, IPsiNodeFactory<PsiElement>>): HashMap<IElementType, IPsiNodeFactory<PsiElement>> {
//        val resultHashMap = HashMap<IElementType, IPsiNodeFactory<PsiElement>>()
//        maps
//            .flatMap { it.entries }
//            .forEach {
//                if (!resultHashMap.containsKey(it.key)) {
//                    resultHashMap[it.key] = it.value
//                } else {
//                    logger.error(
//                        "Duplicate usage of IElementType ${it.key.debugName} " +
//                                "as key for value ${it.value.javaClass.simpleName} " +
//                                "and value ${resultHashMap[it.key]?.javaClass?.simpleName}"
//                    )
//                }
//            }
//        return resultHashMap
//    }
//
//    private infix fun TokenSet.mapsTo(that: IPsiNodeFactory<PsiElement>): Map<IElementType, IPsiNodeFactory<PsiElement>> {
//        return this.types.associateWith { that }
//    }
}
