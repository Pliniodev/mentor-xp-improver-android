package com.pliniodev.src

import org.gradle.api.Project
import org.gradle.api.artifacts.ProjectDependency

class RootProjectAccessor(private val project: Project) {
    val featuresDogs: ProjectDependency get() = 
        project.dependencies.project(mapOf("path" to ":features:dogs")) as ProjectDependency
    val coreNavigation: ProjectDependency get() =
        project.dependencies.project(mapOf("path" to ":core:navigation")) as ProjectDependency
    val coreNetwork: ProjectDependency get() =
        project.dependencies.project(mapOf("path" to ":core:network")) as ProjectDependency
}