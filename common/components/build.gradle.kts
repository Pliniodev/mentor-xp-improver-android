import com.pliniodev.src.plugins.MainGradlewPlugin

plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.ksp)
}

apply<MainGradlewPlugin>()

android {
    namespace = "com.pliniodev.xpimprover.common.components"
}

dependencies {
    // projects
    implementation(projects.common.theme)

    // compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.compose.bom))

    implementation(libs.coil)
    implementation(libs.coil.compose)

    // core
    implementation(libs.bundles.ktx)
    implementation(libs.material3)
    implementation(libs.ksp)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}