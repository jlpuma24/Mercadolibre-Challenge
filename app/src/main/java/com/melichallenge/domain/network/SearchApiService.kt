package com.melichallenge.domain.network

import com.melichallenge.BuildConfig
import com.melichallenge.domain.model.SearchResult
import com.melichallenge.framework.di.util.Constants.SEARCH_PARAMETER
import okhttp3.OkHttpClient
import org.koin.core.component.KoinComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val SEARCH_PATH = "sites/MLA/search/"

interface SearchApiService {

    @GET(SEARCH_PATH)
    suspend fun getProductsBySearchTerm(@Query(SEARCH_PARAMETER) searchParameter: String): Response<SearchResult>

    companion object: KoinComponent {
        fun create(converterFactory: GsonConverterFactory, client: OkHttpClient): SearchApiService = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build().create(SearchApiService::class.java)
    }
}