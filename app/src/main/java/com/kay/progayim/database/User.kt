package com.kay.progayim.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var name: String,
    var email: String,
    var passwd : String
)