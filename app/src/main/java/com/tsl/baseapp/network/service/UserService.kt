package com.tsl.baseapp.network.service

import com.tsl.baseapp.data.base.BaseResponse
import com.tsl.baseapp.network.User
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 12:38 PM
 */
interface UserService {
    @GET("/users/1")
    suspend fun getUserList():Response<User>
}

//https://jsonplaceholder.typicode.com/users