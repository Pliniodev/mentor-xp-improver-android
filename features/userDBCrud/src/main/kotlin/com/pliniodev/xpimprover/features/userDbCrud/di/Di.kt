package com.pliniodev.xpimprover.features.userDbCrud.di

import com.pliniodev.xpimprover.features.userDbCrud.domain.UserCrudUseCase
import com.pliniodev.xpimprover.features.userDbCrud.ui.UserCrudHomeScreenModel
import com.pliniodev.xpimprover.features.userDbCrud.data.UserCrudUseCaseImpl
import org.koin.dsl.module

val userCrudModule = module {
    // screen model
    factory { UserCrudHomeScreenModel(useCase = get()) }

    // repository
    factory<UserCrudUseCase> {
        UserCrudUseCaseImpl(
            userDao = get()
        )
    }
}