package com.kay.progayim.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var login: String,
    var email: String,
    //var role: Role,
    var password : String
)
//
//@Entity
//data class Role(
//    val admin:String,
//    val user:String
//)