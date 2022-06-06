package com.melichallenge.domain.usecases

import com.melichallenge.domain.repository.detail.ProductDetailRepository
import com.melichallenge.presentation.view.actions.ProductDetailActions
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.Exception

class GetProductDescriptionUseCase: KoinComponent {

    private val productDetailRepository: ProductDetailRepository by inject()

    suspend fun execute(productId: String): ProductDetailActions {
        return try {
            val productDescription = productDetailRepository.getProductDescription(productId)
            ProductDetailActions.OnProductDescriptionReceived(productDescription)
        } catch (e: Exception) {
            ProductDetailActions.OnProductDescriptionError
        }
    }
}