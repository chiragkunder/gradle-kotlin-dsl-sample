import com.ckundr.plugins.androidApplicationConfig
import com.ckundr.plugins.generatedSourceModules
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

androidApplicationConfig(com.ckundr.plugins.Versions.applicationId)

configure<SourceSetContainer> {
    named("main") {
        java.srcDir(project.generatedSourceModules)
    }
}

dependencies { 
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
//    implementation(project(Modules.precompiled))
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
