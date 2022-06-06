package com.melichallenge.framework.di

import com.melichallenge.domain.network.ProductDetailApiService
import com.melichallenge.domain.network.SearchApiService
import com.melichallenge.domain.network.interceptor.ConnectivityInterceptor
import com.melichallenge.framework.di.util.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

private const val HTTP_SIMPLE_CLIENT = "HttpSimpleClient"
private const val CONNECTIVITY = "Connectivity"

val networkModule = module {
    single<GsonConverterFactory> { GsonConverterFactory.create() }
    single(named(CONNECTIVITY)) { ConnectivityInterceptor(androidContext()) }
    factory(named(HTTP_SIMPLE_CLIENT)) { Utils.getOkHttpClient(get(named(CONNECTIVITY))) }
    single { SearchApiService.create(get(), get(named(HTTP_SIMPLE_CLIENT))) }
    single { ProductDetailApiService.create(get(), get(named(HTTP_SIMPLE_CLIENT))) }
}