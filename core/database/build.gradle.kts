import com.pliniodev.src.plugins.MainGradlewPlugin

plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization") version libs.versions.kotlin
}

apply<MainGradlewPlugin>()

android {
    namespace = "com.pliniodev.xpimprover.core.database"
}

dependencies {
    // core
    implementation(libs.bundles.ktx)
    implementation(libs.ksp)

    // lyricist
    implementation(libs.bundles.lyricist)
    ksp(libs.lyricist.processor)

    // koin
    implementation(libs.bundles.koin)

    // kotlin serialization
    implementation(libs.kotlin.serialization.json)

    // room
    implementation(libs.bundles.room) {
        exclude(group = "com.intellij", module = "annotations")
    }

    // test
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.android.test)
}

ksp {
    arg("lyricist.internalVisibility", "true")
    arg("lyricist.generateStringsProperty", "true")
}

//configurations.all {
//    resolutionStrategy {
//        force("org.jetbrains:annotations:23.0.0")
//    }
//}