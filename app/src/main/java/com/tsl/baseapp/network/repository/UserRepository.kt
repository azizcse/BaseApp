package com.tsl.baseapp.network.repository

import com.tsl.baseapp.data.base.BaseResponse
import retrofit2.Response

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 12:55 PM
 */
interface UserRepository {
    suspend fun getUserList():Response<BaseResponse<String>>
}