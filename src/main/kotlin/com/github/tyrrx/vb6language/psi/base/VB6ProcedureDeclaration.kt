package com.github.tyrrx.vb6language.psi.base

import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner

interface VB6ProcedureDeclaration :
        VB6NamedElementOwner,
        VB6ArgumentOwner,
        VB6VisibilityOwner {
}