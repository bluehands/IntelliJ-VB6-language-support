package com.github.tyrrx.vb6language.psi.tree.definition.variable

import com.github.tyrrx.vb6language.psi.base.VB6SubscriptsOwner
import com.github.tyrrx.vb6language.psi.declarations.VB6VariableDeclaration
import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.mixins.VB6TypeHintOwnerMixin
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner
import com.intellij.psi.PsiElement

/**
 * This interface specifies a (static) variable declaration element
 *
 * Merged:
 *  Dim-Statement: https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
 *  Static-Statement: https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa266296(v=vs.60)
 *
 */
interface VB6VariableListElement :
        VB6VariableDeclaration,
        VB6VisibilityOwner,
        VB6TypeClauseOwner,
        VB6SubscriptsOwner,
        VB6TypeHintOwnerMixin {

    val isModuleVariable: Boolean

    // reference to variableStmt or moduleVariableStmt
    val parentVariableStmt: PsiElement

    // not valid in module with events https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/aa243352(v=vs.60)
    val isArray: Boolean
    val withEvents: Boolean
    val isStatic: Boolean
}