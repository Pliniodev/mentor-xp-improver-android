import com.pliniodev.src.plugins.MainGradlewPlugin

plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization") version libs.versions.kotlin
}

apply<MainGradlewPlugin>()

android {
    namespace = "com.pliniodev.xpimprover.features.meuModulo"
}

dependencies {
    // projects
    implementation(projects.core.network)
    implementation(projects.core.navigation)
    implementation(projects.common.components)

    // compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.compose.bom))

    // core
    implementation(libs.bundles.ktx)
    implementation(libs.material3)
    implementation(libs.ksp)

    // retrofit
    implementation(libs.retrofit)

    // lyricist
    implementation(libs.bundles.lyricist)
    ksp(libs.lyricist.processor)

    // voyager
    implementation(libs.bundles.voyager)

    // koin
    implementation(libs.bundles.koin)

    // kotlin serialization
    implementation(libs.kotlin.serialization.json)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}

ksp {
    arg("lyricist.internalVisibility", "true")
    arg("lyricist.generateStringsProperty", "true")
}