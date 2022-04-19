package com.github.tyrrx.vb6language.language

import com.github.tyrrx.vb6language.parser.VisualBasic6Parser
import com.github.tyrrx.vb6language.psi.tree.definition.VB6PsiNode
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6BlockImpl
import com.github.tyrrx.vb6language.psi.tree.definition.block.VB6BlockStmtImpl
import com.github.tyrrx.vb6language.psi.tree.definition.blockStmt.*
import com.github.tyrrx.vb6language.psi.tree.definition.call.*
import com.github.tyrrx.vb6language.psi.tree.definition.conditional.*
import com.github.tyrrx.vb6language.psi.tree.definition.general.*
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6AmbiguousKeywordImpl
import com.github.tyrrx.vb6language.psi.tree.definition.identifier.VB6IdentifierImpl
import com.github.tyrrx.vb6language.psi.tree.definition.literal.VB6LiteralImpl
import com.github.tyrrx.vb6language.psi.tree.definition.loops.*
import com.github.tyrrx.vb6language.psi.tree.definition.module.*
import com.github.tyrrx.vb6language.psi.tree.definition.type.*
import com.github.tyrrx.vb6language.psi.tree.definition.variable.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType

@Suppress("DuplicatedCode")
object PSIFactory {

    private val logger = Logger.getInstance(PSIFactory::class.java)

    fun createElement(node: ASTNode): PsiElement {
        val elementType = node.elementType as RuleIElementType

        return ruleFactoryMap[elementType.ruleIndex]
            ?.createPsiNode(node)
            ?: VB6PsiNode(node)
    }

    private val ruleFactoryMap = safeMap(
        // module ---------------------------------
        VisualBasic6Parser.RULE_module mapsTo VB6ModuleImpl.Factory,
        VisualBasic6Parser.RULE_moduleHeader mapsTo VB6ModuleHeaderImpl.Factory,
        VisualBasic6Parser.RULE_moduleConfigElement mapsTo VB6ModuleConfigElementImpl.Factory,
        VisualBasic6Parser.RULE_moduleConfig mapsTo VB6ModuleConfigImpl.Factory,
        VisualBasic6Parser.RULE_moduleDeclarationsElement mapsTo VB6ModuleDeclarationsElementImpl.Factory,
        VisualBasic6Parser.RULE_moduleDeclarations mapsTo VB6ModuleDeclarationsImpl.Factory,

        VisualBasic6Parser.RULE_functionStmt mapsTo VB6FunctionStatementImpl.Factory,
        VisualBasic6Parser.RULE_subStmt mapsTo VB6SubroutineStatementImpl.Factory,
        VisualBasic6Parser.RULE_propertyGetStmt mapsTo VB6PropertyGetStatementImpl.Factory,
        VisualBasic6Parser.RULE_propertySetStmt mapsTo VB6PropertySetStatementImpl.Factory,
        VisualBasic6Parser.RULE_propertyLetStmt mapsTo VB6PropertyLetStatementImpl.Factory,
        VisualBasic6Parser.RULE_declareStmt mapsTo VB6DeclareStmtImpl.Factory,
        VisualBasic6Parser.RULE_declareFunction mapsTo VB6DeclareFunctionImpl.Factory,
        VisualBasic6Parser.RULE_declareAlias mapsTo VB6DeclareAliasImpl.Factory,
        VisualBasic6Parser.RULE_declareLib mapsTo VB6DeclareLibImpl.Factory,
        VisualBasic6Parser.RULE_enumerationStmt mapsTo VB6EnumerationStmtImpl.Factory,
        VisualBasic6Parser.RULE_enumerationConstant mapsTo VB6EnumerationConstantImpl.Factory,
        VisualBasic6Parser.RULE_eventStmt mapsTo VB6EventStmtImpl.Factory,
        VisualBasic6Parser.RULE_typeStmt mapsTo VB6TypeStmtImpl.Factory,
        VisualBasic6Parser.RULE_typeStmtMember mapsTo VB6TypeStmtMemberImpl.Factory,
        VisualBasic6Parser.RULE_moduleVariableStmt mapsTo VB6ModuleVariableStmtImpl.Factory,
        VisualBasic6Parser.RULE_moduleBody mapsTo VB6ModuleBodyImpl.Factory,
        VisualBasic6Parser.RULE_moduleBodyElement mapsTo VB6ModuleBodyElementImpl.Factory,
        VisualBasic6Parser.RULE_moduleAttributes mapsTo VB6ModuleAttributesImpl.Factory,
        // general ---------------------------------------------------------------------------,
        VisualBasic6Parser.RULE_typeHint mapsTo VB6TypeHintImpl.Factory,
        VisualBasic6Parser.RULE_argList mapsTo VB6ArgumentListImpl.Factory,
        VisualBasic6Parser.RULE_arg mapsTo VB6ArgumentImpl.Factory,

        VisualBasic6Parser.RULE_ambiguousIdentifier mapsTo VB6IdentifierImpl.Factory,
        VisualBasic6Parser.RULE_ambiguousKeyword mapsTo VB6AmbiguousKeywordImpl.Factory,

        VisualBasic6Parser.RULE_argDefaultValue mapsTo VB6ArgumentDefaultValueImpl.Factory,

        VisualBasic6Parser.RULE_type_ mapsTo VB6TypeRuleImpl.Factory,
        VisualBasic6Parser.RULE_baseType mapsTo VB6BaseTypeImpl.Factory,
        VisualBasic6Parser.RULE_complexType mapsTo VB6ComplexTypeImpl.Factory,
        VisualBasic6Parser.RULE_firstComplexTypeElement mapsTo VB6FirstComplexTypeElementImpl.Factory,
        VisualBasic6Parser.RULE_followingComplexTypeElement mapsTo VB6FollowingComplexTypeElementImpl.Factory,
        VisualBasic6Parser.RULE_asTypeClause mapsTo VB6AsTypeClauseImpl.Factory,
        VisualBasic6Parser.RULE_fieldLength mapsTo VB6FieldLengthImpl.Factory,

        VisualBasic6Parser.RULE_literal mapsTo VB6LiteralImpl.Factory,
        VisualBasic6Parser.RULE_visibility mapsTo VB6VisibilityImpl.Factory,
        VisualBasic6Parser.RULE_expression mapsTo VB6ExpressionImpl.Factory,

        VisualBasic6Parser.RULE_variableListStmt mapsTo VB6VariableListStmtImpl.Factory,
        VisualBasic6Parser.RULE_variableSubStmt mapsTo VB6VariableSubStmtImpl.Factory,
        VisualBasic6Parser.RULE_moduleConstListStmt mapsTo VB6ModuleConstListImpl.Factory,
        VisualBasic6Parser.RULE_constListStmt mapsTo VB6ConstListImpl.Factory,
        VisualBasic6Parser.RULE_constStmt mapsTo VB6ConstStmtImpl.Factory,

        VisualBasic6Parser.RULE_subscripts mapsTo VB6SubscriptsImpl.Factory,
        VisualBasic6Parser.RULE_subscriptElement mapsTo VB6SubscriptElementImpl.Factory,

        // call ---------------------------------------------------------------------------,
        VisualBasic6Parser.RULE_atomicExplicitProcedureCall mapsTo VB6AtomicExplicitProcedureCallImpl.Factory,
        VisualBasic6Parser.RULE_explicitMemberProcedureCall mapsTo VB6ExplicitMemberProcedureCallImpl.Factory,
        VisualBasic6Parser.RULE_blockMembersCall mapsTo VB6BlockMembersCallImpl.Factory,
        VisualBasic6Parser.RULE_atomicBlockCall mapsTo VB6AtomicBlockCallImpl.Factory,
        VisualBasic6Parser.RULE_blockCall mapsTo VB6BlockCallImpl.Factory,    // also in block,
        VisualBasic6Parser.RULE_inlineCall mapsTo VB6InlineCallImpl.Factory,        // also in block,
        VisualBasic6Parser.RULE_inlineVariableOrProcedureCall mapsTo VB6InlineVariableOrProcedureCallImpl.Factory,
        VisualBasic6Parser.RULE_inlineProcedureOrArrayCall mapsTo VB6InlineProcedureOrArrayCallImpl.Factory,
        VisualBasic6Parser.RULE_inlineMembersCall mapsTo VB6InlineMembersCallImpl.Factory,
        VisualBasic6Parser.RULE_inlineMemberCall mapsTo VB6InlineMemberCallImpl.Factory,
        VisualBasic6Parser.RULE_inlineDictionaryCall mapsTo VB6InlineDictionaryCallImpl.Factory,
        VisualBasic6Parser.RULE_atomicInlineCall mapsTo VB6AtomicInlineCallImpl.Factory,
        VisualBasic6Parser.RULE_lastExplicitMemberProcedureCall mapsTo VB6LastExplicitMemberProcedureCallImpl.Factory,
        VisualBasic6Parser.RULE_lastBlockMemberCall mapsTo VB6LastBlockMemberCallImpl.Factory,

        // block ---------------------------------------------------------------------------,
        VisualBasic6Parser.RULE_block mapsTo VB6BlockImpl.Factory,
        VisualBasic6Parser.RULE_blockStmt mapsTo VB6BlockStmtImpl.Factory,
        // block statements ---------------------------------------------------------------------------,
        VisualBasic6Parser.RULE_lineLabel mapsTo VB6LineLabelImpl.Factory,
        VisualBasic6Parser.RULE_appactivateStmt mapsTo VB6AppactivateStmtImpl.Factory,
        VisualBasic6Parser.RULE_attributeStmt mapsTo VB6AttributeStmtImpl.Factory,
        VisualBasic6Parser.RULE_beepStmt mapsTo VB6BeepStmtImpl.Factory,
        VisualBasic6Parser.RULE_chdirStmt mapsTo VB6ChdirStmtImpl.Factory,
        VisualBasic6Parser.RULE_chdriveStmt mapsTo VB6ChdriveStmtImpl.Factory,
        VisualBasic6Parser.RULE_closeStmt mapsTo VB6CloseStmtImpl.Factory,
        VisualBasic6Parser.RULE_dateStmt mapsTo VB6DateStmtImpl.Factory,
        VisualBasic6Parser.RULE_deleteSettingStmt mapsTo VB6DeleteSettingStmtImpl.Factory,
        VisualBasic6Parser.RULE_deftypeStmt mapsTo VB6DeftypeStmtImpl.Factory,
        VisualBasic6Parser.RULE_doLoopStmt mapsTo VB6DoLoopStmtImpl.Factory,
        VisualBasic6Parser.RULE_endStmt mapsTo VB6EndStmtImpl.Factory,
        VisualBasic6Parser.RULE_eraseStmt mapsTo VB6EraseStmtImpl.Factory,
        VisualBasic6Parser.RULE_errorStmt mapsTo VB6ErrorStmtImpl.Factory,
        VisualBasic6Parser.RULE_exitStmt mapsTo VB6ExitStmtImpl.Factory,
        VisualBasic6Parser.RULE_explicitCallStmt mapsTo VB6ExplicitCallStmtImpl.Factory,
        VisualBasic6Parser.RULE_filecopyStmt mapsTo VB6FilecopyStmtImpl.Factory,
        VisualBasic6Parser.RULE_forEachStmt mapsTo VB6ForEachStmtImpl.Factory,
        VisualBasic6Parser.RULE_forNextStmt mapsTo VB6ForNextStmtImpl.Factory,
        VisualBasic6Parser.RULE_getStmt mapsTo VB6GetStmtImpl.Factory,
        VisualBasic6Parser.RULE_goSubStmt mapsTo VB6GoSubStmtImpl.Factory,
        VisualBasic6Parser.RULE_goToStmt mapsTo VB6GoToStmtImpl.Factory,
        VisualBasic6Parser.RULE_ifThenElseStmt mapsTo VB6IfThenElseStmtImpl.Factory,
        VisualBasic6Parser.RULE_implementsStmt mapsTo VB6ImplementsStmtImpl.Factory,
        VisualBasic6Parser.RULE_inputStmt mapsTo VB6InputStmtImpl.Factory,
        VisualBasic6Parser.RULE_killStmt mapsTo VB6KillStmtImpl.Factory,
        VisualBasic6Parser.RULE_letStmt mapsTo VB6LetStmtImpl.Factory,
        VisualBasic6Parser.RULE_lineInputStmt mapsTo VB6LineInputStmtImpl.Factory,
        VisualBasic6Parser.RULE_loadStmt mapsTo VB6LoadStmtImpl.Factory,
        VisualBasic6Parser.RULE_lockStmt mapsTo VB6LockStmtImpl.Factory,
        VisualBasic6Parser.RULE_lsetStmt mapsTo VB6LsetStmtImpl.Factory,
        VisualBasic6Parser.RULE_macroStmt mapsTo VB6MacroStmtImpl.Factory,
        VisualBasic6Parser.RULE_midStmt mapsTo VB6MidStmtImpl.Factory,
        VisualBasic6Parser.RULE_mkdirStmt mapsTo VB6MkdirStmtImpl.Factory,
        VisualBasic6Parser.RULE_nameStmt mapsTo VB6NameStmtImpl.Factory,
        VisualBasic6Parser.RULE_onErrorStmt mapsTo VB6OnErrorStmtImpl.Factory,
        VisualBasic6Parser.RULE_onGoToStmt mapsTo VB6OnGoToStmtImpl.Factory,
        VisualBasic6Parser.RULE_onGoSubStmt mapsTo VB6OnGoSubStmtImpl.Factory,
        VisualBasic6Parser.RULE_openStmt mapsTo VB6OpenStmtImpl.Factory,
        VisualBasic6Parser.RULE_printStmt mapsTo VB6PrintStmtImpl.Factory,
        VisualBasic6Parser.RULE_putStmt mapsTo VB6PutStmtImpl.Factory,
        VisualBasic6Parser.RULE_raiseEventStmt mapsTo VB6RaiseEventStmtImpl.Factory,
        VisualBasic6Parser.RULE_randomizeStmt mapsTo VB6RandomizeStmtImpl.Factory,
        VisualBasic6Parser.RULE_redimStmt mapsTo VB6RedimStmtImpl.Factory,
        VisualBasic6Parser.RULE_resetStmt mapsTo VB6ResetStmtImpl.Factory,
        VisualBasic6Parser.RULE_resumeStmt mapsTo VB6ResumeStmtImpl.Factory,
        VisualBasic6Parser.RULE_returnStmt mapsTo VB6ReturnStmtImpl.Factory,
        VisualBasic6Parser.RULE_rmdirStmt mapsTo VB6RmdirStmtImpl.Factory,
        VisualBasic6Parser.RULE_rsetStmt mapsTo VB6RsetStmtImpl.Factory,
        VisualBasic6Parser.RULE_savepictureStmt mapsTo VB6SavepictureStmtImpl.Factory,
        VisualBasic6Parser.RULE_saveSettingStmt mapsTo VB6SaveSettingStmtImpl.Factory,
        VisualBasic6Parser.RULE_seekStmt mapsTo VB6SeekStmtImpl.Factory,
        VisualBasic6Parser.RULE_selectCaseStmt mapsTo VB6SelectCaseStmtImpl.Factory,
        VisualBasic6Parser.RULE_sendkeysStmt mapsTo VB6SendkeysStmtImpl.Factory,
        VisualBasic6Parser.RULE_setattrStmt mapsTo VB6SetattrStmtImpl.Factory,
        VisualBasic6Parser.RULE_setStmt mapsTo VB6SetStmtImpl.Factory,
        VisualBasic6Parser.RULE_stopStmt mapsTo VB6StopStmtImpl.Factory,
        VisualBasic6Parser.RULE_timeStmt mapsTo VB6TimeStmtImpl.Factory,
        VisualBasic6Parser.RULE_unloadStmt mapsTo VB6UnloadStmtImpl.Factory,
        VisualBasic6Parser.RULE_unlockStmt mapsTo VB6UnlockStmtImpl.Factory,
        VisualBasic6Parser.RULE_variableStmt mapsTo VB6VariableStmtImpl.Factory,
        VisualBasic6Parser.RULE_whileWendStmt mapsTo VB6WhileWendStmtImpl.Factory,
        VisualBasic6Parser.RULE_widthStmt mapsTo VB6WidthStmtImpl.Factory,
        VisualBasic6Parser.RULE_withStmt mapsTo VB6WithStmtImpl.Factory,
        VisualBasic6Parser.RULE_writeStmt mapsTo VB6WriteStmtImpl.Factory,
        VisualBasic6Parser.RULE_forSelfReference mapsTo VB6ForSelfReferenceImpl.Factory,

        VisualBasic6Parser.RULE_inlineIfThenElse mapsTo VB6InlineIfThenElseImpl.Factory,
        VisualBasic6Parser.RULE_blockIfThenElse mapsTo VB6BlockIfThenElseImpl.Factory,
        VisualBasic6Parser.RULE_ifConditionStmt mapsTo VB6IfConditionStmtImpl.Factory,
        VisualBasic6Parser.RULE_thenBlockStmt mapsTo VB6ThenBlockStmtImpl.Factory,
        VisualBasic6Parser.RULE_elseBlockStmt mapsTo VB6ElseBlockStmtImpl.Factory,
        VisualBasic6Parser.RULE_ifBlockStmt mapsTo VB6IfBlockStmtImpl.Factory,
        VisualBasic6Parser.RULE_ifElseBlockStmt mapsTo VB6IfElseBlockStmtImpl.Factory,
        VisualBasic6Parser.RULE_ifElseIfBlockStmt mapsTo VB6IfElseIfBlockStmtImpl.Factory
    )

    private fun safeMap(vararg maps: Pair<Int, IPsiNodeFactory<*>>): Map<Int, IPsiNodeFactory<*>> {
        val resultHashMap = HashMap<Int, IPsiNodeFactory<*>>()
        maps.forEach {
            if (!resultHashMap.containsKey(it.first)) {
                resultHashMap[it.first] = it.second
            } else {
                logger.error(
                    "Duplicate usage of IElementType ${VB6IElementTypes.rules[it.first].debugName} " +
                            "as key for value ${it.second.javaClass.simpleName} " +
                            "and value ${resultHashMap[it.first]?.javaClass?.simpleName}"
                )
            }
        }
        return resultHashMap
    }

    private infix fun Int.mapsTo(that: IPsiNodeFactory<*>): Pair<Int, IPsiNodeFactory<*>> {
        return this to that
    }
}
