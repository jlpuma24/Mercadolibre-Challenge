package com.melichallenge.presentation.view.listeners

import com.melichallenge.domain.model.Results

class OnClickListener(val clickListener: (product: Results) -> Unit) {
    fun onClick(product: Results) = clickListener(product)
}