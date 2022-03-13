package com.github.tyrrx.vb6language.psi.language

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.impl.*
import com.github.tyrrx.vb6language.psi.tree.impl.block.VB6BlockImpl
import com.github.tyrrx.vb6language.psi.tree.impl.block.VB6BlockStmtImpl
import com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.*
import com.github.tyrrx.vb6language.psi.tree.impl.blockStmt.conditional.*
import com.github.tyrrx.vb6language.psi.tree.impl.call.*
import com.github.tyrrx.vb6language.psi.tree.impl.module.*
import com.github.tyrrx.vb6language.psi.tree.impl.variable.VB6VariableStmtImpl
import com.github.tyrrx.vb6language.psi.tree.impl.variable.VB6ModuleVariableStmtImpl
import com.github.tyrrx.vb6language.psi.tree.impl.variable.VB6VariableListStmtImpl
import com.github.tyrrx.vb6language.psi.tree.impl.variable.VB6VariableSubStmtImpl
import com.intellij.lang.ASTNode
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType

@Suppress("DuplicatedCode")
object PSIFactory {

	private val logger = Logger.getInstance(PSIFactory::class.java)

	fun createElement(node: ASTNode): PsiElement {
		val elementType = node.elementType
		return if (elementType is RuleIElementType) {
			when (elementType.ruleIndex) {
				// module ---------------------------------
				VisualBasic6Parser.RULE_module -> VB6ModuleImpl.Factory
				VisualBasic6Parser.RULE_moduleHeader -> VB6ModuleHeaderImpl.Factory
				VisualBasic6Parser.RULE_moduleConfigElement -> VB6ModuleConfigElementImpl.Factory
				VisualBasic6Parser.RULE_moduleConfig -> VB6ModuleConfigImpl.Factory
				VisualBasic6Parser.RULE_moduleDeclarationsElement -> VB6ModuleDeclarationsElementImpl.Factory
				VisualBasic6Parser.RULE_moduleDeclarations -> VB6ModuleDeclarationsImpl.Factory

				VisualBasic6Parser.RULE_functionStmt -> VB6FunctionStatementImpl.Factory
				VisualBasic6Parser.RULE_subStmt -> VB6SubroutineStatementImpl.Factory
				VisualBasic6Parser.RULE_propertyGetStmt -> VB6PropertyGetStatementImpl.Factory
				VisualBasic6Parser.RULE_propertySetStmt -> VB6PropertySetStatementImpl.Factory
				VisualBasic6Parser.RULE_propertyLetStmt -> VB6PropertyLetStatementImpl.Factory
				VisualBasic6Parser.RULE_declareStmt -> VB6DeclareStmtImpl.Factory
				VisualBasic6Parser.RULE_enumerationStmt -> VB6EnumerationStmtImpl.Factory
				VisualBasic6Parser.RULE_eventStmt -> VB6EventStmtImpl.Factory
				VisualBasic6Parser.RULE_typeStmt -> VB6TypeStmtImpl.Factory
				VisualBasic6Parser.RULE_moduleVariableStmt -> VB6ModuleVariableStmtImpl.Factory
				VisualBasic6Parser.RULE_moduleBody -> VB6ModuleBodyImpl.Factory
				VisualBasic6Parser.RULE_moduleBodyElement -> VB6ModuleBodyElementImpl.Factory
				// general ---------------------------------------------------------------------------
				VisualBasic6Parser.RULE_typeHint -> VB6TypeHintImpl.Factory
				VisualBasic6Parser.RULE_argList -> VB6ArgumentListImpl.Factory
				VisualBasic6Parser.RULE_arg -> VB6ArgumentImpl.Factory

				VisualBasic6Parser.RULE_ambiguousIdentifier -> VB6IdentifierImpl.Factory
				VisualBasic6Parser.RULE_ambiguousKeyword -> VB6AmbiguousKeywordImpl.Factory

				VisualBasic6Parser.RULE_argDefaultValue -> VB6ArgumentDefaultValueImpl.Factory

				VisualBasic6Parser.RULE_type_ -> VB6TypeRuleImpl.Factory
				VisualBasic6Parser.RULE_baseType-> VB6BaseTypeImpl.Factory
				VisualBasic6Parser.RULE_complexType-> VB6ComplexTypeImpl.Factory
				VisualBasic6Parser.RULE_asTypeClause -> VB6AsTypeClauseImpl.Factory
				VisualBasic6Parser.RULE_fieldLength-> VB6FieldLengthImpl.Factory

				VisualBasic6Parser.RULE_literal -> VB6LiteralImpl.Factory
				VisualBasic6Parser.RULE_visibility -> VB6VisibilityImpl.Factory
				VisualBasic6Parser.RULE_valueStmt -> VB6ValueImpl.Factory

				VisualBasic6Parser.RULE_variableListStmt -> VB6VariableListStmtImpl.Factory
				VisualBasic6Parser.RULE_variableSubStmt -> VB6VariableSubStmtImpl.Factory

				VisualBasic6Parser.RULE_subscripts -> VB6SubscriptsImpl.Factory
				VisualBasic6Parser.RULE_subscriptElement -> VB6SubscriptElementImpl.Factory

				// call ---------------------------------------------------------------------------
				VisualBasic6Parser.RULE_eCS_ProcedureCall -> VB6eCS_ProcedureCallImpl.Factory
				VisualBasic6Parser.RULE_eCS_MemberProcedureCall -> VB6eCS_MemberProcedureCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_B_MemberProcedureCall -> VB6iCS_B_MemberProcedureCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_B_ProcedureCall -> VB6iCS_B_ProcedureCallImpl.Factory
				VisualBasic6Parser.RULE_implicitCallStmt_InBlock -> VB6ImplicitCallStmt_InBlockImpl.Factory 	// also in block
				VisualBasic6Parser.RULE_implicitCallStmt_InStmt -> VB6ImplicitCallStmt_InStmtImpl.Factory 		// also in block
				VisualBasic6Parser.RULE_iCS_S_VariableOrProcedureCall -> VB6iCS_S_VariableOrProcedureCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_S_ProcedureOrArrayCall -> VB6iCS_S_ProcedureOrArrayCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_S_MembersCall -> VB6iCS_S_MembersCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_S_MemberCall -> VB6iCS_S_MemberCallImpl.Factory
				VisualBasic6Parser.RULE_iCS_S_DictionaryCall -> VB6iCS_S_DictionaryCallImpl.Factory

				// block ---------------------------------------------------------------------------
				VisualBasic6Parser.RULE_block-> VB6BlockImpl.Factory
				VisualBasic6Parser.RULE_blockStmt-> VB6BlockStmtImpl.Factory
				// block statements ---------------------------------------------------------------------------
				VisualBasic6Parser.RULE_lineLabel -> VB6LineLabelImpl.Factory
				VisualBasic6Parser.RULE_appactivateStmt -> VB6AppactivateStmtImpl.Factory
				VisualBasic6Parser.RULE_attributeStmt -> VB6AttributeStmtImpl.Factory
				VisualBasic6Parser.RULE_beepStmt -> VB6BeepStmtImpl.Factory
				VisualBasic6Parser.RULE_chdirStmt -> VB6ChdirStmtImpl.Factory
				VisualBasic6Parser.RULE_chdriveStmt -> VB6ChdriveStmtImpl.Factory
				VisualBasic6Parser.RULE_closeStmt -> VB6CloseStmtImpl.Factory
				VisualBasic6Parser.RULE_constStmt -> VB6ConstStmtImpl.Factory
				VisualBasic6Parser.RULE_constSubStmt -> VB6ConstSubStmtImpl.Factory // sub
				VisualBasic6Parser.RULE_dateStmt -> VB6DateStmtImpl.Factory
				VisualBasic6Parser.RULE_deleteSettingStmt -> VB6DeleteSettingStmtImpl.Factory
				VisualBasic6Parser.RULE_deftypeStmt -> VB6DeftypeStmtImpl.Factory
				VisualBasic6Parser.RULE_doLoopStmt -> VB6DoLoopStmtImpl.Factory
				VisualBasic6Parser.RULE_endStmt -> VB6EndStmtImpl.Factory
				VisualBasic6Parser.RULE_eraseStmt -> VB6EraseStmtImpl.Factory
				VisualBasic6Parser.RULE_errorStmt -> VB6ErrorStmtImpl.Factory
				VisualBasic6Parser.RULE_exitStmt -> VB6ExitStmtImpl.Factory
				VisualBasic6Parser.RULE_explicitCallStmt -> VB6ExplicitCallStmtImpl.Factory
				VisualBasic6Parser.RULE_filecopyStmt -> VB6FilecopyStmtImpl.Factory
				VisualBasic6Parser.RULE_forEachStmt -> VB6ForEachStmtImpl.Factory
				VisualBasic6Parser.RULE_forNextStmt -> VB6ForNextStmtImpl.Factory
				VisualBasic6Parser.RULE_getStmt -> VB6GetStmtImpl.Factory
				VisualBasic6Parser.RULE_goSubStmt -> VB6GoSubStmtImpl.Factory
				VisualBasic6Parser.RULE_goToStmt -> VB6GoToStmtImpl.Factory
				VisualBasic6Parser.RULE_ifThenElseStmt -> VB6IfThenElseStmtImpl.Factory
				VisualBasic6Parser.RULE_implementsStmt -> VB6ImplementsStmtImpl.Factory
				VisualBasic6Parser.RULE_inputStmt -> VB6InputStmtImpl.Factory
				VisualBasic6Parser.RULE_killStmt -> VB6KillStmtImpl.Factory
				VisualBasic6Parser.RULE_letStmt -> VB6LetStmtImpl.Factory
				VisualBasic6Parser.RULE_lineInputStmt -> VB6LineInputStmtImpl.Factory
				VisualBasic6Parser.RULE_loadStmt -> VB6LoadStmtImpl.Factory
				VisualBasic6Parser.RULE_lockStmt -> VB6LockStmtImpl.Factory
				VisualBasic6Parser.RULE_lsetStmt -> VB6LsetStmtImpl.Factory
				VisualBasic6Parser.RULE_macroStmt -> VB6MacroStmtImpl.Factory
				VisualBasic6Parser.RULE_midStmt -> VB6MidStmtImpl.Factory
				VisualBasic6Parser.RULE_mkdirStmt -> VB6MkdirStmtImpl.Factory
				VisualBasic6Parser.RULE_nameStmt -> VB6NameStmtImpl.Factory
				VisualBasic6Parser.RULE_onErrorStmt -> VB6OnErrorStmtImpl.Factory
				VisualBasic6Parser.RULE_onGoToStmt -> VB6OnGoToStmtImpl.Factory
				VisualBasic6Parser.RULE_onGoSubStmt -> VB6OnGoSubStmtImpl.Factory
				VisualBasic6Parser.RULE_openStmt -> VB6OpenStmtImpl.Factory
				VisualBasic6Parser.RULE_printStmt -> VB6PrintStmtImpl.Factory
				VisualBasic6Parser.RULE_putStmt -> VB6PutStmtImpl.Factory
				VisualBasic6Parser.RULE_raiseEventStmt -> VB6RaiseEventStmtImpl.Factory
				VisualBasic6Parser.RULE_randomizeStmt -> VB6RandomizeStmtImpl.Factory
				VisualBasic6Parser.RULE_redimStmt -> VB6RedimStmtImpl.Factory
				VisualBasic6Parser.RULE_resetStmt -> VB6ResetStmtImpl.Factory
				VisualBasic6Parser.RULE_resumeStmt -> VB6ResumeStmtImpl.Factory
				VisualBasic6Parser.RULE_returnStmt -> VB6ReturnStmtImpl.Factory
				VisualBasic6Parser.RULE_rmdirStmt -> VB6RmdirStmtImpl.Factory
				VisualBasic6Parser.RULE_rsetStmt -> VB6RsetStmtImpl.Factory
				VisualBasic6Parser.RULE_savepictureStmt -> VB6SavepictureStmtImpl.Factory
				VisualBasic6Parser.RULE_saveSettingStmt -> VB6SaveSettingStmtImpl.Factory
				VisualBasic6Parser.RULE_seekStmt -> VB6SeekStmtImpl.Factory
				VisualBasic6Parser.RULE_selectCaseStmt -> VB6SelectCaseStmtImpl.Factory
				VisualBasic6Parser.RULE_sendkeysStmt -> VB6SendkeysStmtImpl.Factory
				VisualBasic6Parser.RULE_setattrStmt -> VB6SetattrStmtImpl.Factory
				VisualBasic6Parser.RULE_setStmt -> VB6SetStmtImpl.Factory
				VisualBasic6Parser.RULE_stopStmt -> VB6StopStmtImpl.Factory
				VisualBasic6Parser.RULE_timeStmt -> VB6TimeStmtImpl.Factory
				VisualBasic6Parser.RULE_unloadStmt -> VB6UnloadStmtImpl.Factory
				VisualBasic6Parser.RULE_unlockStmt -> VB6UnlockStmtImpl.Factory
				VisualBasic6Parser.RULE_variableStmt -> VB6VariableStmtImpl.Factory
				VisualBasic6Parser.RULE_whileWendStmt -> VB6WhileWendStmtImpl.Factory
				VisualBasic6Parser.RULE_widthStmt -> VB6WidthStmtImpl.Factory
				VisualBasic6Parser.RULE_withStmt -> VB6WithStmtImpl.Factory
				VisualBasic6Parser.RULE_writeStmt -> VB6WriteStmtImpl.Factory

				VisualBasic6Parser.RULE_inlineIfThenElse -> VB6InlineIfThenElseImpl.Factory
				VisualBasic6Parser.RULE_blockIfThenElse -> VB6BlockIfThenElseImpl.Factory
				VisualBasic6Parser.RULE_ifConditionStmt -> VB6IfConditionStmtImpl.Factory
				VisualBasic6Parser.RULE_thenBlockStmt -> VB6ThenBlockStmtImpl.Factory
				VisualBasic6Parser.RULE_elseBlockStmt -> VB6ElseBlockStmtImpl.Factory
				VisualBasic6Parser.RULE_ifBlockStmt -> VB6IfBlockStmtImpl.Factory
				VisualBasic6Parser.RULE_ifElseBlockStmt -> VB6IfElseBlockStmtImpl.Factory
				VisualBasic6Parser.RULE_ifElseIfBlockStmt -> VB6IfElseIfBlockStmtImpl.Factory

				else -> object : IPsiNodeFactory<PsiElement> {
					override fun createPsiNode(node: ASTNode): PsiElement {
						return VB6PsiNode(node)
					}
				}
			}.createPsiNode(node)
		} else {
			VB6PsiNode(node)
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
