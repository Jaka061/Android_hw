package com.kay.progayim.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var name: String,
    var company: String,
    var salary: Int
)