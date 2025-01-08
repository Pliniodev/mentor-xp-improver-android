package com.pliniodev.xpimprover.core.database.di

import com.pliniodev.xpimprover.core.database.AppDatabase
import org.koin.dsl.module
import androidx.room.Room

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
}