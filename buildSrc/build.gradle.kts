plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

gradlePlugin {
    plugins {
        register("common-binary-plugin") {
            id = "common-binary-plugin"
            implementationClass = "com.ckundr.plugins.CommonBinaryPlugin"
        }
    }
}

apply("../common.gradle.kts")

dependencies {
    implementation(rootProject.extra["androidGradlePlugin"].toString())
    implementation(rootProject.extra["kotlinPlugin"].toString())
}