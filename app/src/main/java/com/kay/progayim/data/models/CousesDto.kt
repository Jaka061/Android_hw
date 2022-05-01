package com.kay.progayim.data.models

data class ResponseDto(
    val results: List<CoursesDto>
)
data class CoursesDto(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val location : Location,
    val image: String,
    val url: String,
    val created: String,
    val episode: List<String>,
)
data class Location(
    val name: String,
    val url: String
)