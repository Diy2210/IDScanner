plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

val mppLibs = listOf(
    Deps.Libs.MultiPlatform.mokoResources,
    Deps.Libs.MultiPlatform.mokoWidgets,
    Deps.Libs.MultiPlatform.kotlinStdLib,
    Deps.Libs.MultiPlatform.coroutines,
    Deps.Libs.MultiPlatform.ktorClient,
    Deps.Libs.MultiPlatform.serialization,
    Deps.Libs.MultiPlatform.lifecycle
)

setupFramework(
    exports = mppLibs
)

dependencies {
    mppLibs.forEach { mppLibrary(it) }
}

multiplatformResources {
    multiplatformResourcesPackage = "${Versions.App.namespace}.library"
}
