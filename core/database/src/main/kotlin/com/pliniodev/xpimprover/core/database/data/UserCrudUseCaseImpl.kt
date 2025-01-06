package com.pliniodev.xpimprover.core.database.data

import com.pliniodev.xpimprover.core.database.domain.User
import com.pliniodev.xpimprover.core.database.domain.UserCrudUseCase

internal class UserCrudUseCaseImpl(
    private val userDao: UserDao,
) : UserCrudUseCase {
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toDatabase())
    }

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
            .map { user -> user.toDomain() }
    }

    override suspend fun getUserByName(name: String): User? {
        return userDao.getUserByName(name)?.toDomain()
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.toDatabase())
    }
}