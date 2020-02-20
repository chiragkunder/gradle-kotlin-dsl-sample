import com.ckundr.plugins.androidTestDependencies
import com.ckundr.plugins.kotlinProject
import com.ckundr.plugins.unitTestDependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("common-config")
}

dependencies {
    kotlinProject()
    unitTestDependencies()
    androidTestDependencies()
}
