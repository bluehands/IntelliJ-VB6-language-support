/*
* Copyright (C) 2014 Ulrich Wolffgang <u.wol@wwu.de>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

/*
* Visual Basic 6.0 Grammar for ANTLR4
*
* This is an approximate grammar for Visual Basic 6.0, derived
* from the Visual Basic 6.0 language reference
* http://msdn.microsoft.com/en-us/library/aa338033%28v=vs.60%29.aspx
* and tested against MSDN VB6 statement examples as well as several Visual
* Basic 6.0 code repositories.
*
* Characteristics:
*
* 1. This grammar is line-based and takes into account whitespace, so that
*    member calls (e.g. "A.B") are distinguished from contextual object calls
*    in WITH statements (e.g. "A .B").
*
* 2. Keywords can be used as identifiers depending on the context, enabling
*    e.g. "A.Type", but not "Type.B".
*
*
* Known limitations:
*
* 1. Preprocessor statements (#if, #else, ...) must not interfere with regular
*    statements.
*
* Change log:
*
* v1.4 Rubberduck
*   - renamed to VBA; goal is to support VBA, and a shorter name is more practical.
*   - added moduleDeclarations rule, moved moduleOptions there; options can now be
*     located anywhere in declarations section, without breaking the parser.
*   - added support for Option Compare Database.
*   - added support for VBA 7.0 PtrSafe attribute for Declare statements.
*   - implemented a fileNumber rule to locate identifier usages in file numbers.
*   - added support for anonymous declarations in With blocks (With New Something)
*   - blockStmt rules being sorted alphabetically was wrong. moved implicit call statement last.
*   - '!' in dictionary call statement rule gets picked up as a type hint; changed member call
*     to accept '!' as well as '.', but this complicates resolving the '!' shorthand syntax.
*   - added a subscripts rule in procedure calls, to avoid breaking the parser with
*     a function call that returns an array that is immediately accessed.
*   - added missing macroConstStmt (#CONST) rule.
*   - amended selectCaseStmt rules to support all valid syntaxes.
*   - blockStmt is now illegal in declarations section.
*   - added ON_LOCAL_ERROR token, to support legacy ON LOCAL ERROR statements.
*   - added additional typeHint? token to declareStmt, to support "Declare Function Foo$".
*   - modified WS lexer rule to correctly account for line continuations;
*   - modified multi-word lexer rules to use WS lexer token instead of ' '; this makes
*     the grammar support "Option _\n Explicit" and other keywords being specified on multiple lines.
*	- modified moduleOption rules to account for WS token in corresponding lexer rules.
*   - modified NEWLINE lexer rule to properly support instructions separator (':').
*   - tightened DATELITERAL lexer rule to the format enforced by the VBE, because "#fn: Close #"
*     in "Dim fn: fn = FreeFile: Open "filename" For Output As #fn: Close #fn" was picked up as a date literal.
*   - redefined IDENTIFIER lexer rule to support non-Latin characters (e.g. Japanese)
*   - made seekStmt, lockStmt, unlockStmt, getStmt and widthStmt accept a fileNumber (needed to support '#')
*   - fixed precompiler directives, which can now be nested. they still can't interfere with other blocks though.
*   - optional parameters can be a valueStmt.
*   - added support for Octal and Currency literals.
*   - implemented proper specs for DATELITERAL.
*   - added comments to parse tree (removes known limitation #2).
*   - macroConstStmt now allowed in blockStmt.
*   - allow type hints for parameters.
*
*======================================================================================
*
* v1.3
*	- call statement precedence
*
* v1.2
*	- refined call statements
*
* v1.1
*	- precedence of operators and of ELSE in select statements
*	- optimized member calls
*
* v1.0 Initial revision
*/

grammar VisualBasic6;

// module ----------------------------------

startRule : module EOF;

module :
	WS?
	endOfLine*
	(moduleHeader endOfLine+)?
	(moduleConfig endOfLine+)?
	(moduleAttributes endOfLine+)?
	(moduleDeclarations endOfLine+)?
	moduleBody? endOfLine*
	WS?
;

moduleHeader : VERSION WS DOUBLELITERAL WS CLASS;

//moduleImports: moduleImportElement (endOfLine+ moduleImportElement)*; //todo register

//moduleImportElement: 'Object' WS? EQ WS? STRINGLITERAL WS? ';' WS? STRINGLITERAL; //todo register


moduleConfig :
	BEGIN complexType? endOfLine*
	moduleConfigElement+
	END
;

moduleConfigElement :
	ambiguousIdentifier WS? EQ WS? literal endOfLine*
;

moduleAttributes : (attributeStmt endOfLine+)+;

moduleDeclarations : moduleDeclarationsElement (endOfLine+ moduleDeclarationsElement)*;

moduleOption :
	OPTION_BASE WS SHORTLITERAL 					# optionBaseStmt
	| OPTION_COMPARE WS (BINARY | TEXT | DATABASE) 	# optionCompareStmt
	| OPTION_EXPLICIT 								# optionExplicitStmt
	| OPTION_PRIVATE_MODULE 						# optionPrivateModuleStmt
;

moduleDeclarationsElement :
	comment
	| declareFunctionStmt
	| declareSubStmt
	| enumerationStmt
	| eventStmt
	| moduleConstListStmt
	| implementsStmt
	| moduleVariableStmt
	| moduleOption
	| typeStmt
	| macroStmt
	| attributeStmt
;

macroStmt :
	macroConstStmt
	| macroIfThenElseStmt;

moduleBody :
	moduleBodyElement (endOfLine+ moduleBodyElement)*;

moduleBodyElement :
	functionStmt
	| propertyGetStmt
	| propertySetStmt
	| propertyLetStmt
	| subStmt
	| macroStmt
;


// block ----------------------------------

attributeStmt : ATTRIBUTE WS inlineCall WS? EQ WS? literal (WS? ',' WS? literal)*;

block : blockStmt (endOfStatement blockStmt)* endOfStatement;

blockStmt :
	  lineLabel
    | appactivateStmt
	| attributeStmt
	| beepStmt
	| chdirStmt
	| chdriveStmt
	| closeStmt
	| constListStmt
	| dateStmt
	| deleteSettingStmt
	| deftypeStmt
	| doLoopStmt
	| endStmt
	| eraseStmt
	| errorStmt
	| exitStmt
	| explicitCallStmt
	| filecopyStmt
	| forEachStmt
	| forNextStmt
	| getStmt
	| goSubStmt
	| goToStmt
	| ifThenElseStmt
	| implementsStmt
	| inputStmt
	| killStmt
	| letStmt
	| lineInputStmt
	| loadStmt
	| lockStmt
	| lsetStmt
	| macroStmt
	| midStmt
	| mkdirStmt
	| nameStmt
	| onErrorStmt
	| onGoToStmt
	| onGoSubStmt
	| openStmt
	| printStmt
	| putStmt
	| raiseEventStmt
	| randomizeStmt
	| redimStmt
	| resetStmt
	| resumeStmt
	| returnStmt
	| rmdirStmt
	| rsetStmt
	| savepictureStmt
	| saveSettingStmt
	| seekStmt
	| selectCaseStmt
	| sendkeysStmt
	| setattrStmt
	| setStmt
	| stopStmt
	| timeStmt
	| unloadStmt
	| unlockStmt
	| variableStmt
	| whileWendStmt
	| widthStmt
	| withStmt
	| writeStmt
	| blockCall
    | inlineCall
;


// statements ----------------------------------

appactivateStmt : APPACTIVATE WS expression (WS? ',' WS? expression)?;

beepStmt : BEEP;

chdirStmt : CHDIR WS expression;

chdriveStmt : CHDRIVE WS expression;

closeStmt : CLOSE (WS fileNumber (WS? ',' WS? fileNumber)*)?;

moduleConstListStmt: (visibility WS)? CONST WS constStmt (WS? ',' WS? constStmt)*;
constListStmt : CONST WS constStmt (WS? ',' WS? constStmt)*;

constStmt : ambiguousIdentifier typeHint? (WS asTypeClause)? WS? EQ WS? expression;

dateStmt : DATE WS? EQ WS? expression;

declareFunctionStmt : (visibility WS)? DECLARE WS (PTRSAFE WS)? declareFunction WS ambiguousIdentifier typeHint? WS declareLib declareAlias? (WS? argList)? (WS asTypeClause)?;
declareSubStmt : (visibility WS)? DECLARE WS (PTRSAFE WS)? SUB WS ambiguousIdentifier typeHint? WS declareLib declareAlias? (WS? argList)?;
declareFunction: FUNCTION typeHint?;
declareLib : LIB WS STRINGLITERAL;
declareAlias: WS ALIAS WS STRINGLITERAL;

deftypeStmt :
	(
		DEFBOOL | DEFBYTE | DEFINT | DEFLNG | DEFCUR |
		DEFSNG | DEFDBL | DEFDEC | DEFDATE |
		DEFSTR | DEFOBJ | DEFVAR
	) WS
	letterrange (WS? ',' WS? letterrange)*
;

deleteSettingStmt : DELETESETTING WS expression WS? ',' WS? expression (WS? ',' WS? expression)?;

doLoopStmt :
	DO endOfStatement
	block?
	LOOP
	|
	DO WS (WHILE | UNTIL) WS expression endOfStatement
	block?
	LOOP
	|
	DO endOfStatement
	block
	LOOP WS (WHILE | UNTIL) WS expression
;

endStmt : END;

// https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243358(v=vs.60)
enumerationStmt:
	(visibility WS)? ENUM WS ambiguousIdentifier endOfStatement
	enumerationConstant+ // Compile error: Enum without members not allowed
	END_ENUM
;
// expression must evaluate to a long
enumerationConstant : ambiguousIdentifier (WS? EQ WS? expression)? endOfStatement;

eraseStmt : ERASE WS expression (',' WS? expression)*?;

errorStmt : ERROR WS expression;

eventStmt : (visibility WS)? EVENT WS ambiguousIdentifier WS? argList;

exitStmt : EXIT_DO | EXIT_FOR | EXIT_FUNCTION | EXIT_PROPERTY | EXIT_SUB;

filecopyStmt : FILECOPY WS expression WS? ',' WS? expression;

forEachStmt :
	FOR WS EACH WS forEachStmtIteratorDeclaration typeHint? WS IN WS expression endOfStatement // definition
	block?
	NEXT (WS forSelfReference)? // reference
;
forEachStmtIteratorDeclaration: ambiguousIdentifier;

forNextStmt :
	FOR WS forNextStmtIteratorDeclaration typeHint? (WS asTypeClause)? WS? EQ WS? expression WS TO WS expression (WS STEP WS expression)? endOfStatement
	block?
	NEXT (WS forSelfReference)?
;
forNextStmtIteratorDeclaration: ambiguousIdentifier;

forSelfReference: ambiguousIdentifier;

functionStmt :
	(visibility WS)? (STATIC WS)? FUNCTION WS? ambiguousIdentifier typeHint? (WS? argList)? (WS? asTypeClause)? endOfStatement
	block?
	END_FUNCTION
;

getStmt : GET WS fileNumber WS? ',' WS? expression? WS? ',' WS? expression;

goSubStmt : GOSUB WS expression;

goToStmt : GOTO WS expression;

ifThenElseStmt : inlineIfThenElse | blockIfThenElse;

inlineIfThenElse : IF WS ifConditionStmt WS THEN WS thenBlockStmt (WS ELSE WS elseBlockStmt)?;

thenBlockStmt: blockStmt; // marker for then block statement

elseBlockStmt: blockStmt; // marker for else block statement

blockIfThenElse : ifBlockStmt ifElseIfBlockStmt* ifElseBlockStmt? END_IF;

ifBlockStmt :
	IF WS ifConditionStmt WS THEN endOfStatement
	block?
;

ifConditionStmt : expression;

ifElseIfBlockStmt :
	ELSEIF WS ifConditionStmt WS THEN endOfStatement
	block?
;

ifElseBlockStmt :
	ELSE endOfStatement
	block?
;

implementsStmt : IMPLEMENTS WS ambiguousIdentifier; // reference

inputStmt : INPUT WS fileNumber (WS? ',' WS? expression)+;

killStmt : KILL WS expression;

letStmt : (LET WS)? inlineCall WS? (EQ | PLUS_EQ | MINUS_EQ) WS? expression; // reference

lineInputStmt : LINE_INPUT WS fileNumber WS? ',' WS? expression;

loadStmt : LOAD WS expression;

lockStmt : LOCK WS expression (WS? ',' WS? expression (WS TO WS expression)?)?;

lsetStmt : LSET WS inlineCall WS? EQ WS? expression; // reference

macroConstStmt : MACRO_CONST WS? ambiguousIdentifier WS? EQ WS? expression;

macroIfThenElseStmt : macroIfBlockStmt macroElseIfBlockStmt* macroElseBlockStmt? MACRO_END_IF;

macroIfBlockStmt :
	MACRO_IF WS? ifConditionStmt WS THEN endOfStatement
	(moduleDeclarations | moduleBody | block)*
;

macroElseIfBlockStmt :
	MACRO_ELSEIF WS? ifConditionStmt WS THEN endOfStatement
	(moduleDeclarations | moduleBody | block)*
;

macroElseBlockStmt :
	MACRO_ELSE endOfStatement
	(moduleDeclarations | moduleBody | block)*
;

midStmt : MID WS? LPAREN WS? parameters WS? RPAREN;

mkdirStmt : MKDIR WS expression;

nameStmt : NAME WS expression WS AS WS expression;

onErrorStmt : (ON_ERROR | ON_LOCAL_ERROR) WS (GOTO WS goToDestination | RESUME WS NEXT);

onGoToStmt : ON WS expression WS GOTO WS goToDestinationList;

onGoSubStmt : ON WS expression WS GOSUB WS goToDestinationList;

goToDestinationList: goToDestination (WS? ',' WS? goToDestination)*;    //todo register
// literal must be a long
goToDestination: literal | ambiguousIdentifier;                    //todo register


openStmt :
	OPEN WS expression WS FOR WS (APPEND | BINARY | INPUT | OUTPUT | RANDOM)
	(WS ACCESS WS (READ | WRITE | READ_WRITE))?
	(WS (SHARED | LOCK_READ | LOCK_WRITE | LOCK_READ_WRITE))?
	WS AS WS fileNumber
	(WS LEN WS? EQ WS? expression)?
;

outputList :
	outputList_Expression (WS? (';' | ',') WS? outputList_Expression?)*
	| outputList_Expression? (WS? (';' | ',') WS? outputList_Expression?)+
;

outputList_Expression :
	expression
	| (SPC | TAB) (WS? LPAREN WS? parameters WS? RPAREN)?
;

printStmt : PRINT WS fileNumber WS? ',' (WS? outputList)?;

propertyGetStmt :
	(visibility WS)? (STATIC WS)? PROPERTY_GET WS ambiguousIdentifier typeHint? (WS? argList)? (WS asTypeClause)? endOfStatement
	block?
	END_PROPERTY
;

propertySetStmt :
	(visibility WS)? (STATIC WS)? PROPERTY_SET WS ambiguousIdentifier (WS? argList)? endOfStatement
	block?
	END_PROPERTY
;

propertyLetStmt :
	(visibility WS)? (STATIC WS)? PROPERTY_LET WS ambiguousIdentifier (WS? argList)? endOfStatement
	block?
	END_PROPERTY
;

putStmt : PUT WS fileNumber WS? ',' WS? expression? WS? ',' WS? expression;

raiseEventStmt : RAISEEVENT WS ambiguousIdentifier (WS? LPAREN WS? (parameters WS?)? RPAREN)?; // reference

randomizeStmt : RANDOMIZE (WS expression)?;

redimStmt : REDIM WS (PRESERVE WS)? redimSubStmt (WS?',' WS? redimSubStmt)*;

redimSubStmt : inlineCall WS? LPAREN WS? subscripts WS? RPAREN (WS asTypeClause)?; // reference

resetStmt : RESET;

resumeStmt : RESUME (WS (NEXT | ambiguousIdentifier))?; // reference

returnStmt : RETURN;

rmdirStmt : RMDIR WS expression;

rsetStmt : RSET WS inlineCall WS? EQ WS? expression; // todo

savepictureStmt : SAVEPICTURE WS expression WS? ',' WS? expression;

saveSettingStmt : SAVESETTING WS expression WS? ',' WS? expression WS? ',' WS? expression WS? ',' WS? expression;

seekStmt : SEEK WS fileNumber WS? ',' WS? expression;

selectCaseStmt :
	SELECT WS CASE WS expression endOfStatement
	sC_Case*
	END_SELECT
;

sC_Selection : // Todo split rules to make them visible & implement
    IS WS? comparisonOperator WS? expression                       # caseCondIs
    | expression WS TO WS expression                                # caseCondTo
    | expression                                                   # caseCondValue
;

sC_Case : // todo implement
	CASE WS sC_Cond endOfStatement
	block?
;

// ELSE first, so that it is not interpreted as a variable call
sC_Cond : // Todo split rules to make them visible & implement
    ELSE                                                            # caseCondElse
    | sC_Selection (WS? ',' WS? sC_Selection)*                      # caseCondSelection
;

sendkeysStmt : SENDKEYS WS expression (WS? ',' WS? expression)?;

setattrStmt : SETATTR WS expression WS? ',' WS? expression;

setStmt : SET WS inlineCall WS? EQ WS? expression; // reference

stopStmt : STOP;

subStmt :
	(visibility WS)? (STATIC WS)? SUB WS? ambiguousIdentifier (WS? argList)? endOfStatement
	block?
	END_SUB
;

timeStmt : TIME WS? EQ WS? expression;

// https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa266315(v=vs.60)
typeStmt :
	(visibility WS)? TYPE WS ambiguousIdentifier endOfStatement
	typeStmtMember+ // Compile Error: User defined type without members not allowed.
	END_TYPE
    ;
typeStmtMember : ambiguousIdentifier (WS? LPAREN (WS? subscripts)? WS? RPAREN)? WS asTypeClause endOfStatement;

typeOfStmt : TYPEOF WS expression (WS IS WS type_)?;

unloadStmt : UNLOAD WS expression;

unlockStmt : UNLOCK WS fileNumber (WS? ',' WS? expression (WS TO WS expression)?)?;

// operator precedence is represented by rule order
expression
    : literal 												    # vsLiteral
	| inlineCall 								                # vsICS
	| LPAREN WS? expression (WS? ',' WS? expression)* RPAREN 	# vsStruct
	| NEW WS? expression 									    # vsNew
	| typeOfStmt 											    # vsTypeOf
	| midStmt 												    # vsMid
	| ADDRESSOF WS? expression 								    # vsAddressOf
	| inlineCall WS? ASSIGN WS? expression 		                # vsAssign

	| expression WS? IS WS? expression 						    # vsIs
	| expression WS? LIKE WS? expression 						# vsLike
	| expression WS? GEQ WS? expression 						# vsGeq
	| expression WS? LEQ WS? expression 						# vsLeq
	| expression WS? GT WS? expression 						    # vsGt
	| expression WS? LT WS? expression 						    # vsLt
	| expression WS? NEQ WS? expression 						# vsNeq
	| expression WS? EQ WS? expression 						    # vsEq

	| expression WS? POW WS? expression 						# vsPow
	| MINUS WS? expression 									    # vsNegation
	| PLUS WS? expression 									    # vsPlus
	| expression WS? DIV WS? expression 						# vsDiv
	| expression WS? MULT WS? expression 						# vsMult
	| expression WS? MOD WS? expression 						# vsMod
	| expression WS? PLUS WS? expression 						# vsAdd
	| expression WS? MINUS WS? expression 					    # vsMinus
	| expression WS? AMPERSAND WS? expression 				    # vsAmp

	| expression WS? IMP WS? expression 						# vsImp
	| expression WS? EQV WS? expression 						# vsEqv
	| expression WS? XOR WS? expression 						# vsXor
	| expression WS? OR WS? expression 						    # vsOr
	| expression WS? AND WS? expression 						# vsAnd
	| NOT WS? expression 									    # vsNot
;

variableStmt : (DIM | STATIC) WS variableListStmt; // definition

moduleVariableStmt : (DIM | visibility) WS (WITHEVENTS WS)? variableListStmt; // definition

variableListStmt : variableDeclaration (WS? ',' WS? variableDeclaration)*;

variableDeclaration : ambiguousIdentifier (WS? LPAREN WS? (subscripts WS?)? RPAREN WS?)? typeHint? (WS asTypeClause)?;



whileWendStmt :
	WHILE WS expression endOfStatement
	block?
	WEND
;

widthStmt : WIDTH WS fileNumber WS? ',' WS? expression;

withStmt :
	WITH WS (inlineCall | (NEW WS type_)) endOfStatement
	block?
	END_WITH
;

writeStmt : WRITE WS fileNumber WS? ',' (WS? outputList)?;


fileNumber : '#'? expression;


// complex call statements ----------------------------------

explicitCallStmt
    : atomicExplicitProcedureCall
    | explicitMemberProcedureCall
    ;

// parantheses are required in case of args -> empty parantheses are removed
atomicExplicitProcedureCall : CALL WS ambiguousIdentifier typeHint? (WS? LPAREN WS? parameters WS? RPAREN)? (WS? LPAREN subscripts RPAREN)*; // reference

// parantheses are required in case of args -> empty parantheses are removed
explicitMemberProcedureCall : CALL WS inlineCall? '.' lastExplicitMemberProcedureCall typeHint? (WS? LPAREN WS? parameters WS? RPAREN)? (WS? LPAREN subscripts RPAREN)*; // references
lastExplicitMemberProcedureCall: ambiguousIdentifier;

blockCall
    : blockMembersCall
	| atomicBlockCall
    ;

blockMembersCall : inlineCall? '.' lastBlockMemberCall typeHint? (WS parameters)? dictionaryCallStmt? (WS? LPAREN subscripts RPAREN)*; // references
lastBlockMemberCall: ambiguousIdentifier;

// parantheses are forbidden in case of args
// variables cannot be called in blocks
// certainIdentifier instead of ambiguousIdentifier for preventing ambiguity with statement keywords
atomicBlockCall : ambiguousIdentifier (WS parameters)? (WS? LPAREN subscripts RPAREN)*; // reference


// iCS_S_MembersCall first, so that member calls are not resolved as separate iCS_S_VariableOrProcedureCalls
inlineCall
    : inlineMembersCall
	| atomicInlineCall
	| inlineDictionaryCall
    ;

atomicInlineCall
    : inlineVariableOrProcedureCall
    | inlineProcedureOrArrayCall
    ;

inlineVariableOrProcedureCall : ambiguousIdentifier typeHint? dictionaryCallStmt? (WS? LPAREN subscripts RPAREN)*; // reference

inlineProcedureOrArrayCall : (ambiguousIdentifier | baseType) typeHint? WS? LPAREN WS? (parameters WS?)? RPAREN dictionaryCallStmt? (WS? LPAREN subscripts RPAREN)*; // reference

inlineMembersCall : atomicInlineCall? (('.' | '!') inlineMemberCall)+ dictionaryCallStmt? (WS? LPAREN subscripts RPAREN)*;

inlineMemberCall : inlineVariableOrProcedureCall | inlineProcedureOrArrayCall;

//iCS_S_MembersCall : (iCS_S_VariableOrProcedureCall | iCS_S_ProcedureOrArrayCall)? iCS_S_MemberCall+ dictionaryCallStmt? (WS? LPAREN subscripts RPAREN)*;
//
//iCS_S_MemberCall : ('.' | '!') (iCS_S_VariableOrProcedureCall | iCS_S_ProcedureOrArrayCall);

inlineDictionaryCall : dictionaryCallStmt;


// atomic call statements ----------------------------------

parameters : (parameter? WS? (',' | ';') WS?)* parameter (WS? (',' | ';') WS? parameter?)*; //todo register

parameter : LPAREN? ((BYVAL | BYREF | PARAMARRAY) WS)? RPAREN? expression; //todo register

dictionaryCallStmt : '!' ambiguousIdentifier typeHint?; // reference


// atomic rules for statements

argList : LPAREN (WS? arg (WS? ',' WS? arg)*)? WS? RPAREN;

arg : (OPTIONAL WS)? ((BYVAL | BYREF) WS)? (PARAMARRAY WS)?
    ambiguousIdentifier typeHint? (WS? LPAREN WS? RPAREN)?
    (WS? asTypeClause)? (WS? argDefaultValue)?;

argDefaultValue : EQ WS? expression;


subscripts : subscriptElement (WS? ',' WS? subscriptElement)*;
// expression must evaluate (infere) to a int or long value
subscriptElement : (expression WS TO WS)? expression;


// atomic rules ----------------------------------

ambiguousIdentifier :
	(IDENTIFIER | ambiguousKeyword)+
;

asTypeClause : AS WS? (NEW WS)? type_ (WS? fieldLength)?;

baseType : BOOLEAN | BYTE | COLLECTION | DATE | DOUBLE | INTEGER | LONG | SINGLE
    | STRING (WS? MULT WS? expression)? | VARIANT;

certainIdentifier :
	IDENTIFIER (ambiguousKeyword | IDENTIFIER)*
	| ambiguousKeyword (ambiguousKeyword | IDENTIFIER)+
;

comparisonOperator : LT | LEQ | GT | GEQ | EQ | NEQ | IS | LIKE;

complexType : firstComplexTypeElement (('.' | '!') followingComplexTypeElement)*;
firstComplexTypeElement: ambiguousIdentifier;
followingComplexTypeElement: ambiguousIdentifier;

fieldLength : MULT WS? (INTEGERLITERAL | ambiguousIdentifier);

letterrange : certainIdentifier (WS? MINUS WS? certainIdentifier)?;

lineLabel : ambiguousIdentifier ':';

literal : HEXLITERAL | OCTLITERAL | DATELITERAL | DOUBLELITERAL | INTEGERLITERAL | SHORTLITERAL | STRINGLITERAL | TRUE | FALSE | NOTHING | NULL_;

type_ : (baseType | complexType) (WS? LPAREN WS? RPAREN)?;

typeHint : '&' | '%' | '#' | '!' | '@' | '$';

visibility : PRIVATE | PUBLIC | FRIEND | GLOBAL;

// ambiguous keywords
ambiguousKeyword :
    ACCESS | ADDRESSOF | ALIAS | AND | ATTRIBUTE | APPACTIVATE | APPEND | AS |
	BEEP | BEGIN | BINARY | BOOLEAN | BYVAL | BYREF | BYTE |
	CALL | CASE | CLASS | CLOSE | CHDIR | CHDRIVE | COLLECTION | CONST |
	DATABASE | DATE | DECLARE | DEFBOOL | DEFBYTE | DEFCUR | DEFDBL | DEFDATE | DEFDEC | DEFINT | DEFLNG | DEFOBJ | DEFSNG | DEFSTR | DEFVAR | DELETESETTING | DIM | DO | DOUBLE |
	EACH | /*ELSE | ELSEIF |*/ END | ENUM | EQV | ERASE | ERROR | EVENT | // remove else and else if to prevent matching
	FALSE | FILECOPY | FRIEND | FOR | FUNCTION |
	GET | GLOBAL | GOSUB | GOTO |
	IF | IMP | IMPLEMENTS | IN | INPUT | IS | INTEGER |
	KILL |
	LOAD | LOCK | LONG | LOOP | LEN | LET | LIB | LIKE | LSET |
	ME | MID | MKDIR | MOD |
	NAME | NEXT | NEW | NOT | NOTHING | NULL_ |
	ON | OPEN | OPTIONAL | OR | OUTPUT |
	PARAMARRAY | PRESERVE | PRINT | PRIVATE | PUBLIC | PUT |
	RANDOM | RANDOMIZE | RAISEEVENT | READ | REDIM | REM | RESET | RESUME | RETURN | RMDIR | RSET |
	SAVEPICTURE | SAVESETTING | SEEK | SELECT | SENDKEYS | SET | SETATTR | SHARED | SINGLE | SPC | STATIC | STEP | STOP | STRING | SUB |
	TAB | TEXT | THEN | TIME | TO | TRUE | TYPE | TYPEOF |
	UNLOAD | UNLOCK | UNTIL |
	VARIANT | VERSION |
	WEND | WHILE | WIDTH | WITH | WITHEVENTS | WRITE |
	XOR
;

remComment : REMCOMMENT;

comment : COMMENT;

endOfLine : WS? (NEWLINE | comment | remComment) WS?;

endOfStatement : (endOfLine | WS? COLON WS?)+;


// lexer rules --------------------------------------------------------------------------------


// keywords
ACCESS : A C C E S S;
ADDRESSOF : A D D R E S S O F;
ALIAS : A L I A S;
AND : A N D;
ATTRIBUTE : A T T R I B U T E;
APPACTIVATE : A P P A C T I V A T E;
APPEND : A P P E N D;
AS : A S;
BEGIN : B E G I N;
BEEP : B E E P;
BINARY : B I N A R Y;
BOOLEAN : B O O L E A N;
BYVAL : B Y V A L;
BYREF : B Y R E F;
BYTE : B Y T E;
CALL : C A L L;
CASE : C A S E;
CHDIR : C H D I R;
CHDRIVE : C H D R I V E;
CLASS : C L A S S;
CLOSE : C L O S E;
COLLECTION : C O L L E C T I O N;
CONST : C O N S T;
DATABASE : D A T A B A S E;
DATE : D A T E;
DECLARE : D E C L A R E;
DEFBOOL : D E F B O O L;
DEFBYTE : D E F B Y T E;
DEFDATE : D E F D A T E;
DEFDBL : D E F D B L;
DEFDEC : D E F D E C;
DEFCUR : D E F C U R;
DEFINT : D E F I N T;
DEFLNG : D E F L N G;
DEFOBJ : D E F O B J;
DEFSNG : D E F S N G;
DEFSTR : D E F S T R;
DEFVAR : D E F V A R;
DELETESETTING : D E L E T E S E T T I N G;
DIM : D I M;
DO : D O;
DOUBLE : D O U B L E;
EACH : E A C H;
ELSE : E L S E;
ELSEIF : E L S E I F;
END_ENUM : E N D WS E N U M;
END_FUNCTION : E N D WS F U N C T I O N;
END_IF : E N D WS I F;
END_PROPERTY : E N D WS P R O P E R T Y;
END_SELECT : E N D WS S E L E C T;
END_SUB : E N D WS S U B;
END_TYPE : E N D WS T Y P E;
END_WITH : E N D WS W I T H;
END : E N D;
ENUM : E N U M;
EQV : E Q V;
ERASE : E R A S E;
ERROR : E R R O R;
EVENT : E V E N T;
EXIT_DO : E X I T WS D O;
EXIT_FOR : E X I T WS F O R;
EXIT_FUNCTION : E X I T WS F U N C T I O N;
EXIT_PROPERTY : E X I T WS P R O P E R T Y;
EXIT_SUB : E X I T WS S U B;
FALSE : F A L S E;
FILECOPY : F I L E C O P Y;
FRIEND : F R I E N D;
FOR : F O R;
FUNCTION : F U N C T I O N;
GET : G E T;
GLOBAL : G L O B A L;
GOSUB : G O S U B;
GOTO : G O T O;
IF : I F;
IMP : I M P;
IMPLEMENTS : I M P L E M E N T S;
IN : I N;
INPUT : I N P U T;
IS : I S;
INTEGER : I N T E G E R;
KILL: K I L L;
LOAD : L O A D;
LOCK : L O C K;
LONG : L O N G;
LOOP : L O O P;
LEN : L E N;
LET : L E T;
LIB : L I B;
LIKE : L I K E;
LINE_INPUT : L I N E WS I N P U T;
LOCK_READ : L O C K WS R E A D;
LOCK_WRITE : L O C K WS W R I T E;
LOCK_READ_WRITE : L O C K WS R E A D WS W R I T E;
LSET : L S E T;
MACRO_CONST : '#' C O N S T;
MACRO_IF : '#' I F;
MACRO_ELSEIF : '#' E L S E I F;
MACRO_ELSE : '#' E L S E;
MACRO_END_IF : '#' E N D WS? I F;
ME : M E;
MID : M I D;
MKDIR : M K D I R;
MOD : M O D;
NAME : N A M E;
NEXT : N E X T;
NEW : N E W;
NOT : N O T;
NOTHING : N O T H I N G;
NULL_ : N U L L;
ON : O N;
ON_ERROR : O N WS E R R O R;
ON_LOCAL_ERROR : O N WS L O C A L WS E R R O R;
OPEN : O P E N;
OPTIONAL : O P T I O N A L;
OPTION_BASE : O P T I O N WS B A S E;
OPTION_EXPLICIT : O P T I O N WS E X P L I C I T;
OPTION_COMPARE : O P T I O N WS C O M P A R E;
OPTION_PRIVATE_MODULE : O P T I O N WS P R I V A T E WS M O D U L E;
OR : O R;
OUTPUT : O U T P U T;
PARAMARRAY : P A R A M A R R A Y;
PRESERVE : P R E S E R V E;
PRINT : P R I N T;
PRIVATE : P R I V A T E;
PROPERTY_GET : P R O P E R T Y WS G E T;
PROPERTY_LET : P R O P E R T Y WS L E T;
PROPERTY_SET : P R O P E R T Y WS S E T;
PTRSAFE : P T R S A F E;
PUBLIC : P U B L I C;
PUT : P U T;
RANDOM : R A N D O M;
RANDOMIZE : R A N D O M I Z E;
RAISEEVENT : R A I S E E V E N T;
READ : R E A D;
READ_WRITE : R E A D WS W R I T E;
REDIM : R E D I M;
REM : R E M;
RESET : R E S E T;
RESUME : R E S U M E;
RETURN : R E T U R N;
RMDIR : R M D I R;
RSET : R S E T;
SAVEPICTURE : S A V E P I C T U R E;
SAVESETTING : S A V E S E T T I N G;
SEEK : S E E K;
SELECT : S E L E C T;
SENDKEYS : S E N D K E Y S;
SET : S E T;
SETATTR : S E T A T T R;
SHARED : S H A R E D;
SINGLE : S I N G L E;
SPC : S P C;
STATIC : S T A T I C;
STEP : S T E P;
STOP : S T O P;
STRING : S T R I N G;
SUB : S U B;
TAB : T A B;
TEXT : T E X T;
THEN : T H E N;
TIME : T I M E;
TO : T O;
TRUE : T R U E;
TYPE : T Y P E;
TYPEOF : T Y P E O F;
UNLOAD : U N L O A D;
UNLOCK : U N L O C K;
UNTIL : U N T I L;
VARIANT : V A R I A N T;
VERSION : V E R S I O N;
WEND : W E N D;
WHILE : W H I L E;
WIDTH : W I D T H;
WITH : W I T H;
WITHEVENTS : W I T H E V E N T S;
WRITE : W R I T E;
XOR : X O R;


// symbols
AMPERSAND : '&';
ASSIGN : ':=';
DIV : '\\' | '/';
EQ : '=';
GEQ : '>=';
GT : '>';
LEQ : '<=';
LPAREN : '(';
LT : '<';
MINUS : '-';
MINUS_EQ : '-=';
MULT : '*';
NEQ : '<>';
PLUS : '+';
PLUS_EQ : '+=';
POW : '^';
RPAREN : ')';
L_SQUARE_BRACKET : '[';
R_SQUARE_BRACKET : ']';


// literals
STRINGLITERAL : '"' (~["\r\n] | '""')* '"';
OCTLITERAL : '&O' [0-7]+ '&'?;
HEXLITERAL : '&H' [0-9A-F]+ '&'?;
SHORTLITERAL : (PLUS|MINUS)? DIGIT+ ('#' | '&' | '@')?;
INTEGERLITERAL : SHORTLITERAL (E SHORTLITERAL)?;
DOUBLELITERAL : (PLUS|MINUS)? DIGIT* '.' DIGIT+ (E SHORTLITERAL)?;
DATELITERAL : '#' DATEORTIME '#';
fragment DATEORTIME : DATEVALUE WS? TIMEVALUE | DATEVALUE | TIMEVALUE;
fragment DATEVALUE : DATEVALUEPART DATESEPARATOR DATEVALUEPART (DATESEPARATOR DATEVALUEPART)?;
fragment DATEVALUEPART : DIGIT+ | MONTHNAME;
fragment DATESEPARATOR : WS? [/,-]? WS?;
fragment MONTHNAME : ENGLISHMONTHNAME | ENGLISHMONTHABBREVIATION;
fragment ENGLISHMONTHNAME : J A N U A R Y | F E B R U A R Y | M A R C H | A P R I L | M A Y | J U N E  | A U G U S T | S E P T E M B E R | O C T O B E R | N O V E M B E R | D E C E M B E R;
fragment ENGLISHMONTHABBREVIATION : J A N | F E B | M A R | A P R | J U N | J U L | A U G | S E P |  O C T | N O V | D E C;
fragment TIMEVALUE : DIGIT+ AMPM | DIGIT+ TIMESEPARATOR DIGIT+ (TIMESEPARATOR DIGIT+)? AMPM?;
fragment TIMESEPARATOR : WS? (':' | '.') WS?;
fragment AMPM : WS? (A M | P M | A | P);

// whitespace, line breaks, comments, ...
LINE_CONTINUATION : [ \t]+ UNDERSCORE '\r'? '\n' -> channel(HIDDEN);
NEWLINE : [\r\n\u2028\u2029]+;
REMCOMMENT : COLON? REM WS (LINE_CONTINUATION | ~[\r\n\u2028\u2029])*;
COMMENT : SINGLEQUOTE (LINE_CONTINUATION | ~[\r\n\u2028\u2029])*;
SINGLEQUOTE : '\'';
COLON : ':';
UNDERSCORE : '_';
WS : ([ \t] | LINE_CONTINUATION)+;

// identifier
IDENTIFIER :  ~[\]()\r\n\t.,'"|!@#$%^&*\-+:=; ]+ | L_SQUARE_BRACKET (~[!\]\r\n])+ R_SQUARE_BRACKET;

// letters
fragment LETTER : [a-zA-Z_\p{L}];
fragment DIGIT : [0-9];
fragment LETTERORDIGIT : [a-zA-Z0-9_\p{L}];

// case insensitive chars
fragment A:[aA];
fragment B:[bB];
fragment C:[cC];
fragment D:[dD];
fragment E:[eE];
fragment F:[fF];
fragment G:[gG];
fragment H:[hH];
fragment I:[iI];
fragment J:[jJ];
fragment K:[kK];
fragment L:[lL];
fragment M:[mM];
fragment N:[nN];
fragment O:[oO];
fragment P:[pP];
fragment Q:[qQ];
fragment R:[rR];
fragment S:[sS];
fragment T:[tT];
fragment U:[uU];
fragment V:[vV];
fragment W:[wW];
fragment X:[xX];
fragment Y:[yY];
fragment Z:[zZ];

/** "catch all" rule for any char not matche in a token rule of your
 *  grammar. Lexers in Intellij must return all tokens good and bad.
 *  There must be a token to cover all characters, which makes sense, for
 *  an IDE. The parser however should not see these bad tokens because
 *  it just confuses the issue. Hence, the hidden channel.
 */
ERRCHAR
	:	. -> channel(HIDDEN)
	;
