package com.pliniodev.xpimprover.core.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pliniodev.xpimprover.core.database.domain.User

@Entity(tableName = "users") 
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String
) {
    fun toDomain(): User =
        User(
            name = name,
            email = email,
        )
}