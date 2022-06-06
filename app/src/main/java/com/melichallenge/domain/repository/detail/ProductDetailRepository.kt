package com.melichallenge.domain.repository.detail

import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse

interface ProductDetailRepository {
    suspend fun getProductDescription(productId: String): ProductDescription?
    suspend fun getProductReviews(productId: String): ReviewsResponse?
    suspend fun getProductDetail(productId: String): Product?
}