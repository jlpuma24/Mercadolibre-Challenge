package com.melichallenge.presentation.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.melichallenge.domain.usecases.GetProductDescriptionUseCase
import com.melichallenge.domain.usecases.GetProductDetailUseCase
import com.melichallenge.domain.usecases.GetProductReviewsUseCase
import com.melichallenge.presentation.view.actions.ProductDetailActions
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class ProductDetailViewModel(
    private val getProductDescriptionUseCase: GetProductDescriptionUseCase,
    private val getProductReviewsUseCase: GetProductReviewsUseCase,
    private val getProductDetailUseCase: GetProductDetailUseCase
) : BaseViewModel(), KoinComponent {

    private val onProductDetailActions: MutableLiveData<ProductDetailActions> =
        MutableLiveData<ProductDetailActions>()

    fun updateGalleryCounter(counterCopy: String) {
        onProductDetailActions.postValue(
            ProductDetailActions.OnCounterGalleryPagerUpdated(
                counterCopy
            )
        )
    }

    fun getProductDescription(productId: String) = launch {
        onProductDetailActions.postValue(
            getProductDescriptionUseCase.execute(productId)
        )
    }

    fun getProductReviews(productId: String) = launch {
        onProductDetailActions.postValue(
            getProductReviewsUseCase.execute(productId)
        )
    }

    fun getProductDetail(productId: String) = launch {
        onProductDetailActions.postValue(
            getProductDetailUseCase.execute(productId)
        )
    }

    fun getProductDetailActions(): LiveData<ProductDetailActions> = onProductDetailActions
}