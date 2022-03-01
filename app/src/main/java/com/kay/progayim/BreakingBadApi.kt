package com.kay.progayim

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApi {

    @GET("/api/episodes")
    fun getAll(): Observable<List<Item>>

    @GET("/api/episodes/{id}")
    fun getEpisode(@Path("id") episode_id: Long): Single<List<Item>>
}
