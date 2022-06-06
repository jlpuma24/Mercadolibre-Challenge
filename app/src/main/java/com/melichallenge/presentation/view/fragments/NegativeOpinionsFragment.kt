package com.melichallenge.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.melichallenge.R
import com.melichallenge.databinding.FragmentNegativeOpinionsBinding
import com.melichallenge.domain.model.Review
import com.melichallenge.presentation.view.adapter.ProductReviewsAdapter

class NegativeOpinionsFragment: Fragment() {

    private lateinit var binding: FragmentNegativeOpinionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNegativeOpinionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val reviewsList = arguments?.getSerializable(REVIEW_LIST) as ArrayList<Review>?
        context?.let {
            reviewsList?.let { list ->
                if (!list.isNullOrEmpty()) {
                    binding.rvReviews.apply {
                        val itemDecoration = DividerItemDecoration(it, DividerItemDecoration.VERTICAL)
                        val drawableDecoration = ContextCompat.getDrawable(it, R.drawable.line_divider)
                        if (drawableDecoration != null) {
                            itemDecoration.setDrawable(drawableDecoration)
                            addItemDecoration(itemDecoration)
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(it)
                            adapter = ProductReviewsAdapter(reviewsList)
                            visibility = View.VISIBLE
                        }
                    }
                } else {
                    binding.rvReviews.visibility = View.GONE
                    binding.tvEmptyState.visibility = View.VISIBLE
                }
            }
        }
    }

    fun newInstance(reviewsList: ArrayList<Review>?) = NegativeOpinionsFragment().apply {
        arguments = Bundle().apply {
            putSerializable(REVIEW_LIST, reviewsList)
        }
    }
}