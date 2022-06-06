package com.melichallenge.domain.usecases

import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.repository.detail.ProductDetailRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductDescriptionUseCase: KoinComponent {

    private val productDetailRepository: ProductDetailRepository by inject()

    suspend fun execute(productId: String): ProductDescription? {
        return productDetailRepository.getProductDescription(productId)
    }
}