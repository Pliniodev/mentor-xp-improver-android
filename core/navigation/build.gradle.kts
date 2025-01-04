import com.pliniodev.src.plugins.CoreGradlewPlugin

plugins {
    kotlin("jvm")
}

apply<CoreGradlewPlugin>()

dependencies {
    // koin
    implementation(libs.koin.core)
    // voyager
    implementation(libs.voyager.core)
    // test
    testImplementation(libs.junit)
}