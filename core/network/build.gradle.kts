import com.pliniodev.src.plugins.CoreGradlewPlugin

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version libs.versions.kotlin
}

apply<CoreGradlewPlugin>()

dependencies {
    // koin
    implementation(libs.koin.core)
    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    // kotlin serialization
//    implementation(libs.kotlin.serialization.core)
    implementation(libs.kotlin.serialization.json)
    // okhttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    // test
    testImplementation(libs.junit)
}