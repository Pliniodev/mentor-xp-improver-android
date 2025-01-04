package com.pliniodev.src.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

/**
 * Use this for JVM modules
 */
class CoreGradlewPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugins(target)
        configureKtlint(target)
        configureKotlin(target)
    }

    private fun configureKtlint(project: Project) {
        project.ktlint().apply {
            ignoreFailures.set(false)
            reporters {
                reporter(ReporterType.PLAIN)
                reporter(ReporterType.SARIF)
                reporter(ReporterType.CHECKSTYLE)
            }
        }
    }

    private fun configureKotlin(project: Project) {
        project.extensions.findByType(KotlinJvmProjectExtension::class.java)?.apply {
            jvmToolchain(17)
        }
    }

    private fun Project.ktlint(): KtlintExtension =
        extensions.getByType(KtlintExtension::class.java)

    private fun applyPlugins(project: Project) {
        project.apply {
            plugin("org.jlleitschuh.gradle.ktlint")
            plugin("org.jetbrains.kotlin.jvm")
        }
    }
}