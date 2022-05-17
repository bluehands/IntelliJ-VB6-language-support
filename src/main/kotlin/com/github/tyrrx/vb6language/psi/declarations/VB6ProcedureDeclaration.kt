package com.github.tyrrx.vb6language.psi.declarations

import com.github.tyrrx.vb6language.psi.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.scope.VB6VisibilityOwner

interface VB6ProcedureDeclaration :
        VB6NamedElementOwner,
        VB6ArgumentOwner,
        VB6VisibilityOwner {
}