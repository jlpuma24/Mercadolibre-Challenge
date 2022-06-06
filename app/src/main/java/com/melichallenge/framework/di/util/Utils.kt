package com.melichallenge.framework.di.util

import android.util.Log
import com.melichallenge.domain.network.interceptor.ConnectivityInterceptor
import com.melichallenge.framework.di.util.Constants.APP_TAG_NETWORK
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Utils {

    fun getOkHttpClient(connectivityInterceptor: ConnectivityInterceptor? = null): OkHttpClient {
        val client = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d(
                APP_TAG_NETWORK,
                message
            )
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(httpLoggingInterceptor)
        client.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        client.readTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        client.writeTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        connectivityInterceptor?.let { interceptor -> client.addInterceptor(interceptor) }
        return client.build()
    }
}