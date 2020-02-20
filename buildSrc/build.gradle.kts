import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("common-config") {
            id = "common-config"
            implementationClass = "com.ckundr.plugins.CommonConfiguration"
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
}