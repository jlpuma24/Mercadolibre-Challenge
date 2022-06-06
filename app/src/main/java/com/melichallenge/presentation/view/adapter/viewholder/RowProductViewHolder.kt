package com.melichallenge.presentation.view.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.R
import com.melichallenge.databinding.RowProductBinding
import com.melichallenge.domain.model.Results
import com.melichallenge.presentation.view.listeners.OnClickListener
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.Locale

class RowProductViewHolder(v: View, private val onClickListener: OnClickListener) : RecyclerView.ViewHolder(v) {

    private var view: View = v
    private val currencyFormatter = NumberFormat.getInstance(Locale.GERMANY)

    fun bindItem(itemData: Results) = with(view) {

        val binding = RowProductBinding.bind(view)
        val context = view.context

        view.setOnClickListener {
            onClickListener.onClick(itemData)
        }

        binding.tvProductName.text = itemData.title
        binding.tvProductPrice.text =
            context.getString(R.string.money_format, currencyFormatter.format(itemData.price?.toInt()))

        if (itemData.installments != null) {
            val installmentObject = itemData.installments
            binding.tvProductInstallments.text = context.getString(
                R.string.installments_format,
                installmentObject?.quantity?.toLong().toString(),
                currencyFormatter.format(installmentObject?.amount?.toLong())
            )
        }

        if (itemData.shipping != null) {
            val shipping = itemData.shipping
            if (shipping?.freeShipping == false) {
                binding.tvFreeShipping.visibility = View.GONE
            }
        }

        Picasso.get()
            .load(itemData.thumbnail)
            .into(binding.ivProduct, object : Callback {
                override fun onSuccess() {
                    binding.pbProductLoader.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    binding.pbProductLoader.visibility = View.GONE
                }
            })
    }
}