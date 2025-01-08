package com.pliniodev.xpimprover.features.userDbCrud.di

import com.pliniodev.xpimprover.features.userDbCrud.ui.UserCrudHomeScreenModel
import org.koin.dsl.module

val userCrudModule = module {
    // screen model
    factory { UserCrudHomeScreenModel(useCase = get()) }
}