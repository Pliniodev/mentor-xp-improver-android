package com.pliniodev.xpimprover.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pliniodev.xpimprover.core.database.data.User
import com.pliniodev.xpimprover.core.database.data.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}