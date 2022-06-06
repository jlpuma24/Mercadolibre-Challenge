package com.melichallenge.presentation.view.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.databinding.RowReviewBinding
import com.melichallenge.domain.model.Review

class ReviewProductViewHolder (v: View) : RecyclerView.ViewHolder(v) {

    private var view: View = v

    fun bindItem(itemData: Review?) = with(view) {
        val binding = RowReviewBinding.bind(view)
        binding.rbOpinions.rating = itemData?.rate?.toFloat() ?: 0.0f
        binding.tvDislikeComments.text = itemData?.dislikes.toString()
        binding.tvLikeComments.text = itemData?.likes.toString()
        binding.tvReviewText.text = itemData?.content
        binding.tvReviewTitle.text = itemData?.title
    }
}