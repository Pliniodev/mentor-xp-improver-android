package com.pliniodev.xpimprover.core.database.domain

import com.pliniodev.xpimprover.core.database.data.UserEntity

data class User(
    val name: String,
    val email: String
) {
    fun toDatabase(): UserEntity =
        UserEntity(
            name = name,
            email = email,
        )
}