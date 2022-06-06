package com.melichallenge.domain.repository.search

import com.melichallenge.domain.model.SearchResult
import com.melichallenge.domain.network.SearchApiService
import com.melichallenge.domain.network.exceptions.ApiErrorException
import com.melichallenge.domain.network.exceptions.NoConnectivityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.IOException

class SearchItemsRepositoryImpl(private val apiService: SearchApiService) : SearchItemsRepository, KoinComponent {

    override suspend fun getProductsBySearchTerm(searchTerm: String): SearchResult? =
        withContext(Dispatchers.IO) {
            val response = apiService.getProductsBySearchTerm(searchTerm)
            try {
                if (response.isSuccessful) {
                    return@withContext response.body()
                } else {
                    throw ApiErrorException()
                }
            } catch (e: IOException) {
                throw NoConnectivityException()
            }
        }
}