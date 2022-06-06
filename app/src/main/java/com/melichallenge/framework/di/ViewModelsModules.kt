package com.melichallenge.framework.di

import com.melichallenge.domain.usecases.GetProductDescriptionUseCase
import com.melichallenge.domain.usecases.GetProductDetailUseCase
import com.melichallenge.domain.usecases.GetProductReviewsUseCase
import com.melichallenge.domain.usecases.MakeSearchUseCase
import com.melichallenge.presentation.view.viewmodels.ProductDetailViewModel
import com.melichallenge.presentation.view.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        SearchViewModel(
            MakeSearchUseCase()
        )
    }
    viewModel {
        ProductDetailViewModel(
            GetProductDescriptionUseCase(),
            GetProductReviewsUseCase(),
            GetProductDetailUseCase()
        )
    }
}