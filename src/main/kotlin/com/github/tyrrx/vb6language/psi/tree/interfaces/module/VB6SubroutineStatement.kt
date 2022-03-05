package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6SubroutineStatement :
    VB6BlockScope,
    VB6AmbiguousIdentifierOwner,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin {
}