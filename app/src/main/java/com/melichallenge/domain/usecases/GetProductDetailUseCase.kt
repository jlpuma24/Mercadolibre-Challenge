package com.melichallenge.domain.usecases

import com.melichallenge.domain.model.Product
import com.melichallenge.domain.repository.detail.ProductDetailRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductDetailUseCase: KoinComponent {

    private val productDetailRepository: ProductDetailRepository by inject()

    suspend fun execute(productId: String): Product? {
        return productDetailRepository.getProductDetail(productId)
    }
}