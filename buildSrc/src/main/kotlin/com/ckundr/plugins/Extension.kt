package com.ckundr.plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.kotlinProject() {
    "implementation"(Libraries.kotlinStdLib)
}

fun DependencyHandlerScope.unitTestDependencies() {
    "testImplementation"(Libraries.junit)
}

fun DependencyHandlerScope.androidTestDependencies() {
    "androidTestImplementation"(Libraries.testRunner)
    "androidTestImplementation"(Libraries.espressoCore)
}

fun Project.androidApplicationConfig(
    appId: String,
    appVersionCode: Int = Versions.applicationVersionCode,
    appVersionName: String = Versions.applicationVersionName
) {
    androidLibraryConfig {
        applicationId = appId
        versionCode = appVersionCode
        versionName = appVersionName
    }
}

fun Project.androidLibraryConfig(defaultConfigExtensions: (DefaultConfig.() -> Unit)? = null) {
    android.run {
        compileSdkVersion(Versions.compileSdkVersion)
        defaultConfig {
            defaultConfigExtensions?.invoke(this)
            minSdkVersion(Versions.minSdkVersion)
            targetSdkVersion(Versions.targetSdkVersion)
            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
            }
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                consumerProguardFiles("consumer-rules.pro")
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        packagingOptions.exclude("META-INF/main.kotlin_module")
    }
}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")
