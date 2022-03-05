package com.github.tyrrx.vb6language.psi.tree.interfaces.module

import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6AmbiguousIdentifierOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ArgumentOwner
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6BlockScope
import com.github.tyrrx.vb6language.psi.tree.interfaces.base.VB6ReturnsType
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetTypeHintFromChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6IsStaticInChildrenMixin
import com.github.tyrrx.vb6language.psi.tree.mixins.VB6GetVisibilityFromChildrenMixin
import org.antlr.intellij.adaptor.psi.ScopeNode

interface VB6FunctionStatement :
    VB6BlockScope,
    VB6AmbiguousIdentifierOwner,
    VB6ArgumentOwner,
    VB6ReturnsType,
    VB6GetVisibilityFromChildrenMixin,
    VB6IsStaticInChildrenMixin,
    VB6GetTypeHintFromChildrenMixin {

}