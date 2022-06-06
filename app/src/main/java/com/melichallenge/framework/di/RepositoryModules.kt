package com.melichallenge.framework.di

import com.melichallenge.domain.repository.detail.ProductDetailRepository
import com.melichallenge.domain.repository.detail.ProductDetailRepositoryImpl
import com.melichallenge.domain.repository.search.SearchItemsRepository
import com.melichallenge.domain.repository.search.SearchItemsRepositoryImpl
import org.koin.dsl.module

val repositoryModules = module {
    single<SearchItemsRepository> { SearchItemsRepositoryImpl(get()) }
    single<ProductDetailRepository> { ProductDetailRepositoryImpl(get()) }
}