package com.pliniodev.xpimprover.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object FeatureHome : SharedScreen()
    data object UserCrudHome : SharedScreen()
}