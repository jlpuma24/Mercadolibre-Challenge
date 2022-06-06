package com.melichallenge.domain.repository.search

import com.melichallenge.domain.model.SearchResult

interface SearchItemsRepository {
    suspend fun getProductsBySearchTerm(searchTerm: String): SearchResult?
}