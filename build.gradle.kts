// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    apply(from = "common.gradle.kts")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(rootProject.extra["androidGradlePlugin"].toString())
        classpath(rootProject.extra["kotlinPlugin"].toString())
    }
}

allprojects {
    apply(from = "${rootDir.path}/common.gradle.kts")
}

tasks.register<Delete>("clean") {
    allprojects {
        delete(buildDir)
    }
}
