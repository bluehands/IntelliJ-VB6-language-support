package com.github.tyrrx.vb6language.project

import java.nio.file.Path

interface IVB6Project {
    // todo val externalComReferences:
    val projectFilePath: Path
    val projectName: String
}