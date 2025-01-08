package com.pliniodev.xpimprover.core.database.di

import com.pliniodev.xpimprover.core.database.AppDatabase
import org.koin.dsl.module
import androidx.room.Room
import com.pliniodev.xpimprover.core.database.data.UserCrudUseCaseImpl
import com.pliniodev.xpimprover.core.database.domain.UserCrudUseCase

private const val DATABASE_NAME = "xp.improver.database"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(), 
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    
    single { get<AppDatabase>().userDao() }

    // repository
    factory<UserCrudUseCase> { UserCrudUseCaseImpl(userDao = get()) }
}