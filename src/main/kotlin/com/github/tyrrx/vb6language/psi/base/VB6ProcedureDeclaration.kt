package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.inference.VB6TypeClauseOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable

interface VB6ProcedureDeclaration :
        VB6NamedElementOwner,
        VB6ArgumentOwner{
}