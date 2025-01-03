import com.pliniodev.src.plugins.CoreGradlewPlugin

plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlinSerialization) apply false
}

apply<CoreGradlewPlugin>()

dependencies {
    // koin
    implementation(libs.koin.core)
    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    // kotlin serialization
    implementation(libs.kotlin.serialization.core)
    implementation(libs.kotlin.serialization.json)
    // test
    testImplementation(libs.junit)
}