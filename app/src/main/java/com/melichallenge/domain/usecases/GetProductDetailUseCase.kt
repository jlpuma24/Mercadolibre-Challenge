package com.melichallenge.domain.usecases

import com.melichallenge.domain.repository.detail.ProductDetailRepository
import com.melichallenge.presentation.view.actions.ProductDetailActions
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductDetailUseCase: KoinComponent {

    private val productDetailRepository: ProductDetailRepository by inject()

    suspend fun execute(productId: String): ProductDetailActions {
        return try {
            val productDetail = productDetailRepository.getProductDetail(productId)
            ProductDetailActions.OnProductDetailReceived(productDetail)
        } catch (e: Exception) {
            ProductDetailActions.OnProductReviewsError
        }
    }
}