plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.icerock.mobile.multiplatform-units")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        applicationId = Versions.App.namespace
        versionCode = Versions.App.version
        versionName = Versions.App.versionCode
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

val depLibs = listOf(
    Deps.Libs.Android.kotlinStdLib.name,
    Deps.Libs.Android.appCompat.name,
    Deps.Libs.Android.material.name,
    Deps.Libs.Android.recyclerView.name,
    Deps.Libs.Android.appCompat.name,
    Deps.Libs.Android.constraintLayout.name,
    Deps.Libs.MultiPlatform.napier.android!!,
    project(":mpp-library")
)

dependencies {
    depLibs.forEach { implementation(it) }
}

multiplatformUnits {
    classesPackage = Versions.App.namespace
    dataBindingPackage = Versions.App.namespace
    layoutsSourceSet = "main"
}
