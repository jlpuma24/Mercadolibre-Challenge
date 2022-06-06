package com.melichallenge.presentation.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.melichallenge.domain.usecases.MakeSearchUseCase
import com.melichallenge.presentation.view.actions.SearchProductsActions
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class SearchViewModel(
    private val makeSearchUseCase: MakeSearchUseCase
): BaseViewModel(), KoinComponent {

    private val onSearchProductsActions: MutableLiveData<SearchProductsActions> =
        MutableLiveData<SearchProductsActions>()

    fun showLoader() {
        onSearchProductsActions.postValue(SearchProductsActions.ShowLoader)
    }

    fun hideLoader() {
        onSearchProductsActions.postValue(SearchProductsActions.HideLoader)
    }

    fun makeSearch(searchTerm: String) = launch {
        onSearchProductsActions.postValue(makeSearchUseCase.execute(searchTerm))
    }

    fun getSearchProductActions(): LiveData<SearchProductsActions> = onSearchProductsActions
}