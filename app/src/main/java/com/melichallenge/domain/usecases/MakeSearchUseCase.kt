package com.melichallenge.domain.usecases

import com.melichallenge.domain.repository.search.SearchItemsRepository
import com.melichallenge.presentation.view.actions.SearchProductsActions
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MakeSearchUseCase: KoinComponent {

    private val repository: SearchItemsRepository by inject()

    suspend fun execute(searchTerm: String): SearchProductsActions {
        return try {
            if (searchTerm.isNotEmpty()) {
                val searchResults = repository.getProductsBySearchTerm(searchTerm)
                if (!searchResults?.results.isNullOrEmpty()) {
                    SearchProductsActions.OnSearchResult(searchResults)
                } else {
                    SearchProductsActions.OnEmptySearchResult
                }
            } else {
                SearchProductsActions.OnEmptySearchTerm
            }
        } catch (e: Exception) {
            SearchProductsActions.OnSearchResultError
        }
    }
}