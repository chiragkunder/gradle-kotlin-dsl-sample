package com.ckundr.plugins

import org.gradle.api.Project
import java.io.File


val Project.generatedSourceModules : File
    get() = this.projectDir.resolve("buildSrc/build/generated-sources/modules")


val Project.sourceModules : File
    get() = this.projectDir.resolve("buildSrc/src/main/kotlin")