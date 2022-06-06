package com.melichallenge.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.R
import com.melichallenge.domain.model.Review
import com.melichallenge.presentation.view.adapter.viewholder.ReviewProductViewHolder

class ProductReviewsAdapter(private var reviewsList: ArrayList<Review>?) :
    RecyclerView.Adapter<ReviewProductViewHolder>() {

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewProductViewHolder =
        ReviewProductViewHolder(
            parent.inflate(
                R.layout.row_review, false
            )
        )

    override fun onBindViewHolder(holder: ReviewProductViewHolder, position: Int) {
        reviewsList.let {
            holder.bindItem(it?.get(position))
        }
    }

    override fun getItemCount() = reviewsList?.size ?: 0
}