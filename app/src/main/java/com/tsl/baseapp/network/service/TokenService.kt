package com.tsl.baseapp.network.service

import com.tsl.baseapp.network.User
import retrofit2.Response
import retrofit2.http.GET

interface TokenService {
    @GET("/users/1")
    suspend fun getUserList(): Response<User>
}