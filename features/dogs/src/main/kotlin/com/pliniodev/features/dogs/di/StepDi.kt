package com.pliniodev.features.dogs.di

import cafe.adriel.voyager.core.registry.screenModule
import com.pliniodev.features.dogs.ui.DogsHomeScreen
import com.pliniodev.xpimprover.navigation.SharedScreen

val dogsScreenModule = screenModule {
    register<SharedScreen.FeatureHome> {
        DogsHomeScreen()
    }
}