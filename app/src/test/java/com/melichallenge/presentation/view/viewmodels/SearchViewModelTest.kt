package com.melichallenge.presentation.view.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melichallenge.domain.model.Results
import com.melichallenge.domain.model.SearchResult
import com.melichallenge.domain.usecases.MakeSearchUseCase
import com.melichallenge.presentation.view.actions.SearchProductsActions
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

class SearchViewModelTest {

    private lateinit var searchViewModel: SearchViewModel
    private val makeSearchUseCase: MakeSearchUseCase = mockk()

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any search term WHEN make search is called and return success without data THEN return a OnEmptySearchResult action`() =
        runBlockingTest {
            val expectedSearch = "any"
            coEvery {
                makeSearchUseCase.execute(any())
            } returns SearchProductsActions.OnEmptySearchResult

            searchViewModel.makeSearch(expectedSearch)
            val searchAction = searchViewModel.getSearchProductActions().value
            assert(searchAction is SearchProductsActions.OnEmptySearchResult)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any search term WHEN make search is called and return exception provided by API THEN return a OnSearchResultError action`() =
        runBlockingTest {
            val expectedSearch = "any"
            coEvery {
                makeSearchUseCase.execute(any())
            } returns SearchProductsActions.OnSearchResultError

            searchViewModel.makeSearch(expectedSearch)
            val searchAction = searchViewModel.getSearchProductActions().value
            assert(searchAction is SearchProductsActions.OnSearchResultError)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN any search term WHEN make search is called and return success with data (at least one element) THEN return a OnSearchResult action`() =
        runBlockingTest {
            val expectedSearch = "any"
            val resultList = arrayListOf<Results>()
            resultList.add(mockk())
            val expectedSearchResult = SearchResult(
                null,
                null,
                null,
                mockk(),
                resultList,
                mockk(),
                mockk(),
                mockk(),
                mockk()
            )
            coEvery {
                makeSearchUseCase.execute(any())
            } returns SearchProductsActions.OnSearchResult(expectedSearchResult)

            searchViewModel.makeSearch(expectedSearch)
            val searchAction = searchViewModel.getSearchProductActions().value
            assert(searchAction is SearchProductsActions.OnSearchResult)
        }

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        searchViewModel = SearchViewModel(makeSearchUseCase)
    }

    @After
    @ExperimentalCoroutinesApi
    fun tearDown() {
        Dispatchers.resetMain()
    }
}