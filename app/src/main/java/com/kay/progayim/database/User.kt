package com.kay.progayim.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var name: String,
    var lastname: String,
    var age: Int,
    var gender : String,
    var passwd : String
)