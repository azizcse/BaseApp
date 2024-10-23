package com.tsl.baseapp.network.di

import android.content.Context
import com.tsl.baseapp.network.ApiFactory
import com.tsl.baseapp.network.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 1:33 PM
 */
@InstallIn(SingletonComponent::class)
@Module
object ApiServiceModule {

    @Provides
    fun providePaymentService(@ApplicationContext applicationContext: Context): UserService =
        ApiFactory.createService(applicationContext, UserService::class.java)

}