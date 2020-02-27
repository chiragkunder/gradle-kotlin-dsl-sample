package com.ckundr.plugins

import com.squareup.kotlinpoet.TypeSpec
import org.gradle.api.DefaultTask
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.nativeplatform.NativeExecutableFileSpec
import java.io.File

open class ModuleGeneratorTask : DefaultTask() {

    @TaskAction
    fun createModulesConstant() {

        val file = FileSpec.builder("", "Modules")
        val objectBuilder = TypeSpec.objectBuilder("Modules")

        project.allprojects.forEach {
            val property = PropertySpec
                .builder(generateVariableName(it), String::class)
                .addModifiers(KModifier.CONST)
                .initializer("%S", ":${it.name}")
                .build()

            objectBuilder.addProperty(property)
        }


        file.addType(objectBuilder.build())
            .build()
            .writeTo(project.generatedSourceModules)
    }

    private fun generateVariableName(it: Project) = it.name.replace("`", "")
}