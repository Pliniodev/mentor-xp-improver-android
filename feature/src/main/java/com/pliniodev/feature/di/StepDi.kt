package com.pliniodev.feature.di

import cafe.adriel.voyager.core.registry.screenModule
import com.pliniodev.feature.FeatureHomeScreen
import com.pliniodev.xpimprover.navigation.SharedScreen

val featureScreenModule = screenModule {
    register<SharedScreen.FeatureHome> {
        FeatureHomeScreen()
    }
}