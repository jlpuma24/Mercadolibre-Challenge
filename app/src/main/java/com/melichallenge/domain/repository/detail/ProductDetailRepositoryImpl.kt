package com.melichallenge.domain.repository.detail

import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse
import com.melichallenge.domain.network.ProductDetailApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

class ProductDetailRepositoryImpl(private val apiService: ProductDetailApiService) :
    ProductDetailRepository, KoinComponent {

    override suspend fun getProductDescription(productId: String): ProductDescription? =
        withContext(Dispatchers.IO) {
            val response = apiService.getProductDescription(productId)
            try {
                if (response.isSuccessful) {
                    return@withContext response.body()
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                throw e
            }
        }

    override suspend fun getProductReviews(productId: String): ReviewsResponse? =
        withContext(Dispatchers.IO) {
            val response = apiService.getProductReviews(productId)
            try {
                if (response.isSuccessful) {
                    return@withContext response.body()
                } else {
                    throw Exception()
                }
            } catch (e: Exception) {
                throw e
            }
        }

    override suspend fun getProductDetail(productId: String): Product? = withContext(Dispatchers.IO) {
        val response = apiService.getProductDetail(productId)
        try {
            if (response.isSuccessful) {
                return@withContext response.body()
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            throw e
        }
    }
}