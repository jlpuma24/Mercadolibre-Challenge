package com.melichallenge.presentation.view.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melichallenge.domain.usecases.GetProductDescriptionUseCase
import com.melichallenge.domain.usecases.GetProductDetailUseCase
import com.melichallenge.domain.usecases.GetProductReviewsUseCase
import com.melichallenge.presentation.view.actions.ProductDetailActions
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ProductDetailViewModelTest {

    private lateinit var productDetailViewModel: ProductDetailViewModel
    private val getProductDescriptionUseCase: GetProductDescriptionUseCase = mockk()
    private val getProductReviewsUseCase: GetProductReviewsUseCase = mockk()
    private val getProductDetailUseCase: GetProductDetailUseCase = mockk()

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product description API is called and return success result THEN return a OnProductDescriptionReceived action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductDescriptionUseCase.execute(any())
            } returns ProductDetailActions.OnProductDescriptionReceived(mockk())

            productDetailViewModel.getProductDescription(expectedProductId)
            val productDescriptionAction = productDetailViewModel.getProductDetailActions().value
            assert(productDescriptionAction is ProductDetailActions.OnProductDescriptionReceived)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product reviews API is called and return success result THEN return a OnProductReviewsReceived action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductReviewsUseCase.execute(any())
            } returns ProductDetailActions.OnProductReviewsReceived(mockk())

            productDetailViewModel.getProductReviews(expectedProductId)
            val productReviewAction = productDetailViewModel.getProductDetailActions().value
            assert(productReviewAction is ProductDetailActions.OnProductReviewsReceived)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product detail API is called and return success result THEN return a OnProductDetailReceived action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductDetailUseCase.execute(any())
            } returns ProductDetailActions.OnProductDetailReceived(mockk())

            productDetailViewModel.getProductDetail(expectedProductId)
            val productDetailAction = productDetailViewModel.getProductDetailActions().value
            assert(productDetailAction is ProductDetailActions.OnProductDetailReceived)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product detail API is called and return error result THEN return a OnProductDetailError action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductDetailUseCase.execute(any())
            } returns ProductDetailActions.OnProductDetailError

            productDetailViewModel.getProductDetail(expectedProductId)
            val productDetailAction = productDetailViewModel.getProductDetailActions().value
            assert(productDetailAction is ProductDetailActions.OnProductDetailError)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product reviews API is called and return error result THEN return a OnProductReviewsError action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductReviewsUseCase.execute(any())
            } returns ProductDetailActions.OnProductReviewsError

            productDetailViewModel.getProductReviews(expectedProductId)
            val productReviewAction = productDetailViewModel.getProductDetailActions().value
            assert(productReviewAction is ProductDetailActions.OnProductReviewsError)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any product id WHEN get product description API is called and return error result THEN return a OnProductDescriptionError action`() =
        runBlockingTest {
            val expectedProductId = "any"
            coEvery {
                getProductDescriptionUseCase.execute(any())
            } returns ProductDetailActions.OnProductDescriptionError

            productDetailViewModel.getProductDescription(expectedProductId)
            val productDescriptionAction = productDetailViewModel.getProductDetailActions().value
            assert(productDescriptionAction is ProductDetailActions.OnProductDescriptionError)
        }

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        productDetailViewModel = ProductDetailViewModel(
            getProductDescriptionUseCase,
            getProductReviewsUseCase,
            getProductDetailUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}