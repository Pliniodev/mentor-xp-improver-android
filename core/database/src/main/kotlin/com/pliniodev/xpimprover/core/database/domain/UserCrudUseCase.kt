package com.pliniodev.xpimprover.core.database.domain

interface UserCrudUseCase {
    suspend fun insertUser(user: User)
    
    suspend fun getAllUsers(): List<User>

    suspend fun getUserByName(name: String): User?
    
    suspend fun deleteUser(user: User)
}