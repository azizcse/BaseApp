package com.tsl.baseapp.network.service

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RefreshTokenService {
    private val BASE_URL by lazy { "https://jsonplaceholder.typicode.com/" }

    //private static String BASE_URL = "http://32b816dc.ngrok.io/";
    fun getApiClient(): TokenService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TokenService::class.java)
    }

    private fun buildHttpClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor(buildLoggingInterceptor()!!)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    private fun buildLoggingInterceptor(): HttpLoggingInterceptor? {
        return HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.d("Retrofit_Client_Log", message)
                }
            }
        ).setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}