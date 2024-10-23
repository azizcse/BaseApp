package com.tsl.baseapp.network.di

import com.tsl.baseapp.network.repository.UserRepository
import com.tsl.baseapp.network.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 1:38 PM
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository
}