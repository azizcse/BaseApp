package com.tsl.baseapp.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.tsl.baseapp.data.local.PrefKey
import com.tsl.baseapp.data.local.PrefUtil
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 12:38 PM
 */
object ApiFactory {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient
    private val gson by lazy { GsonBuilder().create() }
    const val TIME_OUT = 30L
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"


    fun <Service> createService(
        context: Context,
        serviceClass: Class<Service>,
        timeOut: Long = TIME_OUT,
        enableTokenInterceptor: Boolean = true
    ): Service {
        return getRetrofit(
            context,
            timeOut = timeOut,
            enableTokenInterceptor = enableTokenInterceptor
        ).create(serviceClass)
    }


    /**
     * @return new retrofit instance with the base url and the converter factories
     */
    fun getRetrofit(
        context: Context,
        timeOut: Long = TIME_OUT,
        enableTokenInterceptor: Boolean = true
    ): Retrofit {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getUnsafeClient(context, timeOut, enableTokenInterceptor))
            .build()

        return retrofit
    }

    fun getUnsafeClient(
        context: Context,
        timeOut: Long = TIME_OUT,
        enableTokenInterceptor: Boolean = true
    ): OkHttpClient {

        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        val builder = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(
                LoggingInterceptor.Builder()
                    //.loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("Request")
                    .response("Response")
                    .executor(Executors.newSingleThreadExecutor())
                    .build()
            )
        if (enableTokenInterceptor)
            builder.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${getToken(context)}")
                    //.addHeader("Session-Data", getSessionData(context))
                    //.addHeader("Accept-Language", getLanguageCode(context))
                    .build()
                chain.proceed(request)
            }

        return builder.build()
    }


    private fun getToken(context: Context): String {
        return runBlocking {
            PrefUtil.get(PrefKey.KEY_JWT_TOKEN, "").toString()
        }
    }
}