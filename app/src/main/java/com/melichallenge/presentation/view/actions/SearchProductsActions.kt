package com.melichallenge.presentation.view.actions

import com.melichallenge.domain.model.SearchResult

sealed class SearchProductsActions {
    class OnSearchResult(val searchResult: SearchResult?): SearchProductsActions()
    object OnEmptySearchResult: SearchProductsActions()
    object OnSearchResultError: SearchProductsActions()
    object OnEmptySearchTerm: SearchProductsActions()
    object ShowLoader: SearchProductsActions()
    object HideLoader: SearchProductsActions()
}