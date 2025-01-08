package com.pliniodev.xpimprover.features.userDbCrud.di

import cafe.adriel.voyager.core.registry.screenModule
import com.pliniodev.xpimprover.features.userDbCrud.ui.UserCrudHomeScreen
import com.pliniodev.xpimprover.navigation.SharedScreen

val userCrudScreenModule = screenModule {
    register<SharedScreen.UserCrudHome> {
        UserCrudHomeScreen
    }
}