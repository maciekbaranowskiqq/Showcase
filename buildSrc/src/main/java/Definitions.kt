object ApplicationId {
    const val id = "com.showcase.app"
}


object Versions {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.1"
    const val minSdkVersion = 23
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.2.71"
    const val coreKtx = "1.3.2"
    const val appCompat = "1.2.0"
    const val constraintLayout = "1.1.3"


    const val junit = "4.12"
    const val extJunit = "1.1.2"
    const val espresso = "3.3.0"

    const val androidPlugin = "4.0.1"
    const val kotlinPlugin = "1.4.0"
}

object Modules {
    const val app = ":app"
}


object CoreLibraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object ThirdPartyLibraries {

}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object GradlePlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPlugin}"
}