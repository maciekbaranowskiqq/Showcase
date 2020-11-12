object ApplicationId {
    const val id = "com.showcase.app"
}

object Modules {
    const val app = ":app"
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
    const val hilt = "2.28-alpha"
    const val navigation = "2.3.1"
    const val navigationCompose = "1.0.0-alpha02"
    const val hiltJetpack = "1.0.0-alpha01"
    const val lifecycle = "2.2.0"
    const val googlePlayCore = "1.8.0"
    const val googlePlayCoreKtx = "1.8.1"

    const val junit = "4.12"
    const val extJunit = "1.1.2"
    const val espresso = "3.3.0"
    const val mockK = "1.10.0"

    const val androidPlugin = "4.0.1"
    const val kotlinPlugin = "1.4.0"
}

object CoreLibraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltLifecycleViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltJetpack}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltJetpack}"


    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationDynamicFeaturesFragment =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"

    const val googlePlayCore = "com.google.android.play:core:${Versions.googlePlayCore}"
    const val googlePlayCoreKtx = "com.google.android.play:core-ktx:${Versions.googlePlayCoreKtx}"
}

object ThirdPartyLibraries {

}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"

    const val mockKUnit = "io.mockk:mockk:${Versions.mockK}"
    const val mockKInstrumented = "io.mockk:mockk-android:${Versions.mockK}"
}

object GradlePlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPlugin}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}