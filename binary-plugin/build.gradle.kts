import com.ckundr.plugins.androidTestDependencies
import com.ckundr.plugins.kotlinProject
import com.ckundr.plugins.unitTestDependencies

plugins {
    id("common-binary-plugin")
}

dependencies {
    kotlinProject()
    unitTestDependencies()
    androidTestDependencies()
}
