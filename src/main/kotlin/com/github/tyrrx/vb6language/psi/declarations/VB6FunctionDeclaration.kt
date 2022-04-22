package com.github.tyrrx.vb6language.psi.declarations

import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable

interface VB6FunctionDeclaration :
        VB6ProcedureDeclaration,
        VB6TypeInferable,
        VB6TypeClauseOwner {
}