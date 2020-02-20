import com.android.build.gradle.BaseExtension

private val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error(
            "Project '$name' is not an Android module. Can't " +
                    "access 'android' extension."
        )

project.android.run {
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

dependencies {
    "implementation"("androidx.appcompat:appcompat:1.1.0")
}
