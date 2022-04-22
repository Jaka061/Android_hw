package com.kay.progayim.data.network

import com.kay.progayim.data.models.UserDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface OnlineCoursesApi {

//    @POST("user/create")
//    fun addUser(
//        @Field("id") id: Long,
//        @Field("login") login: String,
//        @Field("password") password: String,
//        @Field("email") email: String
//    )

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: Long) : Single<UserDto>

    @GET("/allusers")
    fun getAll(): Observable<List<UserDto>>

}