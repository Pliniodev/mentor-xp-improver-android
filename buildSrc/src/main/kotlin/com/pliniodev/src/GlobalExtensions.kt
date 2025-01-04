package com.pliniodev.src

import org.gradle.api.Project

val Project.projects: RootProjectAccessor
    get() = RootProjectAccessor(this)