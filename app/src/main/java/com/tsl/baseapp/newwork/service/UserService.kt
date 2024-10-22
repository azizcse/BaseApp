package com.tsl.baseapp.newwork.service

import com.tsl.baseapp.data.base.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 12:38 PM
 */
interface UserService {
    @GET("api/users")
    suspend fun getUserList():Response<BaseResponse<String>>
}