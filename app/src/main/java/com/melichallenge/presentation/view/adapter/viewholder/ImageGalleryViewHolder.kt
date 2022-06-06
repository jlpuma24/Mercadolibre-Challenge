package com.melichallenge.presentation.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.databinding.RowImageBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ImageGalleryViewHolder (private val binding: RowImageBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(imageUrl: String) {
        Picasso.get()
            .load(imageUrl)
            .into(binding.ivSliderImage, object: Callback {
                override fun onSuccess() {
                    binding.pbImageLoader.hide()
                }

                override fun onError(e: Exception?) {
                    binding.pbImageLoader.hide()
                }
            })
    }
}