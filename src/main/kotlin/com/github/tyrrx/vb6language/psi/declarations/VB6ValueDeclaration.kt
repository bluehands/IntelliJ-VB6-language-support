package com.github.tyrrx.vb6language.psi.declarations

import com.github.tyrrx.vb6language.psi.base.VB6NamedElementOwner
import com.github.tyrrx.vb6language.psi.inference.VB6TypeInferable

interface VB6ValueDeclaration:
        VB6NamedElementOwner,
        VB6TypeInferable {
}