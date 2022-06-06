package com.melichallenge.domain.network

import com.melichallenge.BuildConfig
import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse
import com.melichallenge.framework.di.util.Constants
import okhttp3.OkHttpClient
import org.koin.core.component.KoinComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val PRODUCT_ID_URL_PATH = "items/{productId}/description"
const val REVIEWS_ID_URL_PATH = "reviews/item/{productId}"
const val PRODUCT_DETAIL_PATH = "items/{productId}"

interface ProductDetailApiService {

    @GET(PRODUCT_ID_URL_PATH)
    suspend fun getProductDescription(@Path(Constants.PRODUCT_ID) productId: String): Response<ProductDescription>

    @GET(REVIEWS_ID_URL_PATH)
    suspend fun getProductReviews(@Path(Constants.PRODUCT_ID) productId: String): Response<ReviewsResponse>

    @GET(PRODUCT_DETAIL_PATH)
    suspend fun getProductDetail(@Path(Constants.PRODUCT_ID) productId: String): Response<Product>

    companion object: KoinComponent {
        fun create(converterFactory: GsonConverterFactory, client: OkHttpClient): ProductDetailApiService = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build().create(ProductDetailApiService::class.java)
    }
}