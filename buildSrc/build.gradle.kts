import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    id("java-library")
}

gradlePlugin {
    plugins {
        register("common-binary-plugin") {
            id = "common-binary-plugin"
            implementationClass = "com.ckundr.plugins.CommonBinaryPlugin"
        }
        register("module-const-generator") {
            id = "module-const-generator"
            implementationClass = "com.ckundr.plugins.ModuleConstGenerator"
        }
    }
}

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    }
}

repositories {
    jcenter()
    google()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.3"
}

dependencies {
    implementation("com.android.tools.build:gradle:3.4.2")
    implementation("com.android.tools.build:gradle-api:3.4.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    implementation("com.squareup:kotlinpoet:1.3.0")
}