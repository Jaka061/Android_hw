package com.kay.progayim.data.network

import com.kay.progayim.data.models.CoursesDto
import com.kay.progayim.data.models.ResponseDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface OnlineCoursesApi {

    @GET("/api/character")
    fun getAll(): Observable<ResponseDto>

    @GET("/api/character/{id}")
    fun getById(@Path("id") id: Long): Single<CoursesDto>
}