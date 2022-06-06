package com.melichallenge.presentation.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.melichallenge.R
import com.melichallenge.databinding.ActivitySearchBinding
import com.melichallenge.presentation.view.actions.SearchProductsActions
import com.melichallenge.presentation.view.adapter.ProductsAdapter
import com.melichallenge.presentation.view.extensions.hideSoftKeyboard
import com.melichallenge.presentation.view.listeners.OnClickListener
import com.melichallenge.presentation.view.extensions.setProductListProperties
import com.melichallenge.presentation.view.viewmodels.SearchViewModel
import org.koin.android.ext.android.inject

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val searchViewModel: SearchViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
        listenViewModel()
    }

    private fun setListeners() {
        binding.btnSearch.setOnClickListener {
            searchViewModel.showLoader()
            searchViewModel.makeSearch(binding.etSearchBox.text.toString())
        }
    }

    private fun listenViewModel() {
        searchViewModel.getSearchProductActions().observe(this@SearchActivity) { action ->
            if (action is SearchProductsActions.ShowLoader) {
                binding.tvSearchResults.visibility = View.GONE
                this@SearchActivity.hideSoftKeyboard()
                binding.pbLoader.visibility = View.VISIBLE
            }

            if (action is SearchProductsActions.HideLoader) {
                binding.pbLoader.visibility = View.GONE
            }

            if (action is SearchProductsActions.OnSearchResult) {
                searchViewModel.hideLoader()
                buildProductList(action)
            }

            if (action is SearchProductsActions.OnEmptySearchTerm) {
                Snackbar.make(binding.root, getString(R.string.empty_alert), Snackbar.LENGTH_LONG)
                    .show()
            }

            if (action is SearchProductsActions.OnSearchResultError) {
                Snackbar.make(binding.root, getString(R.string.term_search_error), Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun buildProductList(action: SearchProductsActions.OnSearchResult) {
        binding.tvSearchResults.visibility = View.VISIBLE
        binding.rvProducts.setProductListProperties(action.searchResult, ProductsAdapter(), OnClickListener { product ->
            startActivity(Intent(this@SearchActivity, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT_ID, product.id)
            })
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}