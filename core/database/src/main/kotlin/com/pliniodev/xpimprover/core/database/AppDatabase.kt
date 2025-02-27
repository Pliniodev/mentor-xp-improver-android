package com.pliniodev.xpimprover.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pliniodev.xpimprover.core.database.data.UserDao
import com.pliniodev.xpimprover.core.database.data.UserEntity

@Database(entities = [UserEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}