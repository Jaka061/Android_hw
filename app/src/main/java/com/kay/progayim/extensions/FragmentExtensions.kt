package com.kay.progayim.extensions

import com.kay.progayim.data.models.User
import com.kay.progayim.data.models.UserDto

fun UserDto.toUser(): User {

    return User(
        id = this.id,
        name = this.login,
        email = this.email,
        passwd = this.password
    )
}