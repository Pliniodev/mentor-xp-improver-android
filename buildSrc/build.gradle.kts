import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.build.gradle)
    implementation(libs.ktlint.gradle)
    implementation(libs.ksp)
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}