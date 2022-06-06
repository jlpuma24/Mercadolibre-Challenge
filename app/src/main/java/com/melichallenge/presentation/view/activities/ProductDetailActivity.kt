package com.melichallenge.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.melichallenge.databinding.ActivityProductDetailBinding
import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse
import com.melichallenge.presentation.view.actions.ProductDetailActions
import com.melichallenge.presentation.view.extensions.*
import com.melichallenge.presentation.view.viewmodels.ProductDetailViewModel
import org.koin.android.ext.android.inject

const val EXTRA_PRODUCT_ID = "extra_product_id"
val OPINIONS_ARRAY = arrayOf(
    "Todas",
    "Positivas",
    "Negativas"
)

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private val productDetailViewModel: ProductDetailViewModel by inject()
    private var productId: String = ""
    private var reviews: ReviewsResponse? = null
    private var description: ProductDescription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        listenViewModel()
        productId = intent.getStringExtra(EXTRA_PRODUCT_ID).toString()
        productDetailViewModel.getProductDescription(productId)
    }

    private fun listenViewModel() {
        productDetailViewModel.getProductDetailActions()
            .observe(this@ProductDetailActivity) { action ->
                if (action is ProductDetailActions.OnProductDetailReceived) {
                    buildUi(action.product)
                }

                if (action is ProductDetailActions.OnProductReviewsReceived) {
                    reviews = action.reviews
                    productDetailViewModel.getProductDetail(productId)
                }

                if (action is ProductDetailActions.OnProductDescriptionReceived) {
                    description = action.description
                    productDetailViewModel.getProductReviews(productId)
                }

                if (action is ProductDetailActions.OnCounterGalleryPagerUpdated) {
                    updateGalleryCounter(action.copy)
                }
            }
    }

    private fun updateGalleryCounter(copy: String) {
        binding.tvImagesCounter.text = copy
    }

    private fun buildUi(product: Product?) {
        binding.apply {
            setProductInfo(product, productDetailViewModel)
            setReviewsInfo(reviews, product?.title ?: "", supportFragmentManager, lifecycle)
            setDescriptionInfo(description)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}