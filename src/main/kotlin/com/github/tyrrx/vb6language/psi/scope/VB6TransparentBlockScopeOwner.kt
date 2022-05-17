package com.github.tyrrx.vb6language.psi.scope

import com.github.tyrrx.vb6language.psi.base.VB6BlockOwner

interface VB6TransparentBlockScopeOwner : VB6BlockOwner, VB6ScopeNode, VB6EnclosingVisibleNamedElements {
}