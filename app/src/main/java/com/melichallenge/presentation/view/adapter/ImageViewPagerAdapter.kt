package com.melichallenge.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.databinding.RowImageBinding
import com.melichallenge.presentation.view.adapter.viewholder.ImageGalleryViewHolder

class ImageViewPagerAdapter(private val imageUrlList: List<String?>) :
    RecyclerView.Adapter<ImageGalleryViewHolder>() {

    override fun getItemCount() = imageUrlList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryViewHolder {
        val binding = RowImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageGalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageGalleryViewHolder, position: Int) {
        val url = imageUrlList[position]
        url?.let {
            holder.setData(it)
        }
    }
}