package com.pliniodev.features.dogs.di

import cafe.adriel.voyager.core.registry.screenModule
import com.pliniodev.features.dogs.ui.screens.home.DogsHomeScreen
import com.pliniodev.xpimprover.navigation.SharedScreen

/**
 * Module responsible for providing the screens of the Dogs feature.
 * Used because we need to navigate across modules.
 * The DogsHomeScreen is called from app module indirectly,
 * when we use rememberScreen(SharedScreen.FeatureHome) in HomeScreen.kt.
 * If you need to navigate just inside the Dogs feature, you don't need to use a screen module.
 */
val dogsScreenModule = screenModule {
    register<SharedScreen.FeatureHome> {
        DogsHomeScreen()
    }
}