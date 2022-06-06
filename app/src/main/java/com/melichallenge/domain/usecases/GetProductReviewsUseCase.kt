package com.melichallenge.domain.usecases

import com.melichallenge.domain.model.ReviewsResponse
import com.melichallenge.domain.repository.detail.ProductDetailRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductReviewsUseCase: KoinComponent {

    private val productDetailRepository: ProductDetailRepository by inject()

    suspend fun execute(productId: String): ReviewsResponse? {
        return productDetailRepository.getProductReviews(productId)
    }
}