package com.kay.progayim.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Characters(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val location: Location,
    val episode: List<String>,
)
//data class Locations(
//    var name: String,
//    var url : String
//)