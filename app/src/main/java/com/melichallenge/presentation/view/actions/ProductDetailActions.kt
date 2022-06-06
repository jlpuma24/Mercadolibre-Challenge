package com.melichallenge.presentation.view.actions

import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse

sealed class ProductDetailActions {
    class OnProductDescriptionReceived(val description: ProductDescription?): ProductDetailActions()
    class OnProductReviewsReceived(val reviews: ReviewsResponse?): ProductDetailActions()
    class OnProductDetailReceived(val product: Product?): ProductDetailActions()
    class OnCounterGalleryPagerUpdated(val copy: String): ProductDetailActions()
    object OnProductDescriptionError: ProductDetailActions()
    object OnProductReviewsError: ProductDetailActions()
    object ShowLoader: ProductDetailActions()
    object HideLoader: ProductDetailActions()
}
