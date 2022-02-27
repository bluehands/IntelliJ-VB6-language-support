package com.github.tyrrx.vb6language.psi

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.nodes.DeclareDefinition
import com.github.tyrrx.vb6language.psi.tree.nodes.FunctionDefinition
import com.github.tyrrx.vb6language.psi.tree.nodes.ModuleDefinition
import com.github.tyrrx.vb6language.psi.tree.nodes.SubroutineDefinition
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
				VisualBasic6Parser.RULE_functionStmt -> FunctionDefinition.Factory
				VisualBasic6Parser.RULE_subStmt -> SubroutineDefinition.Factory
				VisualBasic6Parser.RULE_module -> ModuleDefinition.Factory
				VisualBasic6Parser.RULE_declareStmt -> DeclareDefinition.Factory
				VisualBasic6Parser.RULE_ambiguousIdentifier -> object : IPsiNodeFactory<PsiElement> {
					override fun createPsiNode(node: ASTNode): PsiElement {
						return ANTLRPsiNode(node)
					}
				}
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
