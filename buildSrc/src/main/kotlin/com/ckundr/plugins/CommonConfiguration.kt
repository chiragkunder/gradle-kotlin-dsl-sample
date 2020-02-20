package com.ckundr.plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CommonConfiguration : Plugin<Project> {

    private val Project.android: BaseExtension
        get() = extensions.findByName("android") as? BaseExtension
            ?: error("Not an Android module: $name")

    override fun apply(project: Project) {
        project.androidConfig()
        project.dependenciesConfig()
    }

    private fun Project.androidConfig() {
        android.run {
            compileSdkVersion(29)
            defaultConfig {
                minSdkVersion(23)
                targetSdkVersion(29)
                versionCode = 1
                versionName = "1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                }
            }
        }
    }

    private fun Project.dependenciesConfig() {
        project.dependencies {
            "implementation"("androidx.appcompat:appcompat:1.1.0")
        }
    }
}