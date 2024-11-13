package com.tsl.baseapp.network.repository

import com.tsl.baseapp.network.User
import com.tsl.baseapp.network.service.RefreshTokenService
import retrofit2.Response

object TokenRepository {
    suspend fun getUsers():Response<User>{
        var service = RefreshTokenService.getApiClient()
        return service.getUserList()
    }
}