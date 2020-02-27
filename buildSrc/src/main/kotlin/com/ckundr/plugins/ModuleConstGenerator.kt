package com.ckundr.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.configure

class ModuleConstGenerator : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.create("createModulesConstant", ModuleGeneratorTask::class.java)

//        val sourceSet: SourceSetContainer = project.the<SourceSetContainer>()
//        sourceSet.java.srcDirs(project.generatedSourceModules)

    }

    val  Project.sourceScontainerts: org.gradle.api.tasks.SourceSetContainer get() =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("sourceSets") as org.gradle.api.tasks.SourceSetContainer

//    fun org.gradle.api.Project.sourceSetes(configure: org.gradle.api.tasks.SourceSetContainer.() -> Unit): Unit =
//        (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("sourceSets", configure)

//    fun addGeneratedToSource(project: Project) {
//        project.sourceSets.matching { it.name == "main" }.all {
//            it.java.srcDir = '/path/to/generated/code'
//        }
//    }
}