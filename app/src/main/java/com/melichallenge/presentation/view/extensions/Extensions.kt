package com.melichallenge.presentation.view.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.melichallenge.R
import com.melichallenge.databinding.ActivityProductDetailBinding
import com.melichallenge.domain.model.Product
import com.melichallenge.domain.model.ProductDescription
import com.melichallenge.domain.model.ReviewsResponse
import com.melichallenge.domain.model.SearchResult
import com.melichallenge.presentation.view.activities.OPINIONS_ARRAY
import com.melichallenge.presentation.view.adapter.ImageViewPagerAdapter
import com.melichallenge.presentation.view.adapter.OpinionsViewPagerAdapter
import com.melichallenge.presentation.view.adapter.ProductsAdapter
import com.melichallenge.presentation.view.listeners.OnClickListener
import com.melichallenge.presentation.view.viewmodels.ProductDetailViewModel
import java.text.NumberFormat
import java.util.Locale

fun RecyclerView.setProductListProperties(
    searchResult: SearchResult?,
    productsAdapter: ProductsAdapter,
    onClickListener: OnClickListener
) {
    this.apply {
        searchResult?.results.let { resultList ->
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            val drawableDecoration = ContextCompat.getDrawable(context, R.drawable.line_divider)
            if (drawableDecoration != null) {
                itemDecoration.setDrawable(drawableDecoration)
                addItemDecoration(itemDecoration)
                adapter = productsAdapter
                productsAdapter.setValues(resultList, onClickListener)
                visibility = View.VISIBLE
            }
        }
    }
}

fun ViewPager2.setUpViewPager(
    imageList: List<String?>,
    productDetailViewModel: ProductDetailViewModel,
) {
    adapter = ImageViewPagerAdapter(imageList)
    orientation = ViewPager2.ORIENTATION_HORIZONTAL
    currentItem = 0
    registerOnPageChangeCallback(
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                productDetailViewModel.updateGalleryCounter("${position + 1} / " + imageList.size)
            }
        }
    )
}

fun Product.transformImagesToList(): List<String?> {
    return pictures.map { it.secureUrl }
}

fun Context.hideSoftKeyboard() {
    try {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            (this as AppCompatActivity).currentFocus?.windowToken,
            0
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun ActivityProductDetailBinding.setDescriptionInfo(it: ProductDescription?) {
    tvDescriptionContent.text = it?.plainText
}

fun ActivityProductDetailBinding.setLocationInfo(it: Product?) {
    tvLocationValue.text = root.context.getString(
        R.string.detail_product_location_format,
        it?.sellerAddress?.state?.name,
        it?.sellerAddress?.city?.name
    )
}

fun ActivityProductDetailBinding.setReviewsInfo(
    it: ReviewsResponse?,
    productTitle: String,
    supportFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) {
    val context = root.context
    tvOpinionsCounts.text =
        context.getString(R.string.detail_product_opinions_format, it?.reviews?.size.toString())
    rbOpinions.rating = it?.ratingAverage?.toFloat() ?: 0.0f
    rbOpinions.visibility = View.VISIBLE
    rbOpinionsCounter.rating = it?.ratingAverage?.toFloat() ?: 0.0f
    tvOpinionsRating.text = (it?.ratingAverage?.toFloat() ?: 0.0f).toString()
    tvOpinionsAboutProduct.text =
        context.getString(R.string.detail_product_opinions_title_format, productTitle)
    tvAverageReviews.text = context.getString(
        R.string.detail_product_opinions_average_format,
        it?.reviews?.size.toString()
    )

    val adapter = OpinionsViewPagerAdapter(supportFragmentManager, lifecycle, it?.reviews)
    vpOpinions.adapter = adapter

    TabLayoutMediator(tlOpinionsType, vpOpinions) { tab, position ->
        tab.text = OPINIONS_ARRAY[position]
    }.attach()
}

fun ActivityProductDetailBinding.setProductInfo(it: Product?, productDetailViewModel: ProductDetailViewModel) {
    val context = root.context
    tvProductTitle.text = it?.title
    tvConditionSelledItems.text = context.getString(
        R.string.detail_product_header_format,
        it?.condition,
        it?.soldQuantity.toString()
    )
    it?.transformImagesToList()?.let { imageUrlList ->
        vpImagesCarousel.setUpViewPager(
            imageUrlList, productDetailViewModel
        )
    }
    setDiscountAndPriceInfo(it)
    setLocationInfo(it)
}

fun ActivityProductDetailBinding.setDiscountAndPriceInfo(it: Product?) {
    val context = root.context
    val currencyFormatter = NumberFormat.getInstance(Locale.GERMANY)
    if (!it?.originalPrice.isNullOrBlank()) {
        val originalPrice = it?.originalPrice?.toInt()
        tvOriginalPrice.text = context.getString(
            R.string.money_format,
            currencyFormatter.format(originalPrice)
        )
        tvOriginalPrice.paintFlags = tvOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        tvOriginalPrice.visibility = View.VISIBLE
        val price = it?.price?.toInt()
        price?.let { priceSafety ->
            originalPrice?.let {
                val percentageOff =
                    (100 - priceSafety.div(originalPrice.toFloat()) * 100).toInt()
                tvPercentageOff.text = context.getString(
                    R.string.detail_product_discount_format,
                    percentageOff.toString()
                )
                tvPercentageOff.visibility = View.VISIBLE
            }
        }
    }
    tvCurrentPrice.text =
        context.getString(R.string.money_format, currencyFormatter.format(it?.price?.toInt()))
}