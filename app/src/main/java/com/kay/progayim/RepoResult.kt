package com.kay.progayim

data class RepoResult(
    val items: List<Item>
)

data class Item(
    val episode_id: Long?,
    val title: String,
    val season: String?,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val series: String
)
