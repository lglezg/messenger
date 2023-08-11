package com.lglez.models.mapers

import com.lglez.models.data.UserFb
import com.lglez.models.domain.User

object UserMapper {
    fun toDomain(user: UserFb): User {
        return User(
            email = user.email,
            password = user.password,
            name = user.name
        )
    }

    fun toData(user: User): UserFb {
        return UserFb(
            email = user.email,
            password = user.password,
            name = user.name
        )
    }
}