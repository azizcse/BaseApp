package com.tsl.baseapp.network.repository

import com.tsl.baseapp.data.base.BaseResponse
import com.tsl.baseapp.network.service.UserService
import retrofit2.Response
import javax.inject.Inject

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 12:55 PM
 */
class UserRepositoryImpl @Inject constructor(private val userService: UserService) : UserRepository {

    override suspend fun getUserList(): Response<BaseResponse<String>> = userService.getUserList()

}