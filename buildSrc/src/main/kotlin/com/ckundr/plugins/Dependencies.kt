package com.ckundr.plugins

object Versions {

    // Project
    const val kotlin = "1.4.30"

    const val compileSdkVersion = 29
    const val minSdkVersion = 23
    const val targetSdkVersion = 29
    const val applicationId = "com.ckundr.gradle_kotlin_dsl_sample"
    const val applicationVersionCode = 1
    const val applicationVersionName = "1.0.0"

    // Android
    const val appcompat = "1.1.0"

    // Testing
    const val junit = "4.12"
    const val testRunner = "1.1.1"
    const val espressoCore = "3.1.1"
}

object Libraries {

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // Android
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}