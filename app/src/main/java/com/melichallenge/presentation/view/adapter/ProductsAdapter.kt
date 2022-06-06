package com.melichallenge.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.melichallenge.R
import com.melichallenge.domain.model.Results
import com.melichallenge.presentation.view.adapter.viewholder.RowProductViewHolder
import com.melichallenge.presentation.view.listeners.OnClickListener

class ProductsAdapter : RecyclerView.Adapter<RowProductViewHolder>() {

    private lateinit var productList: ArrayList<Results>
    private lateinit var onClickListener: OnClickListener

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProductViewHolder =
        RowProductViewHolder(
            parent.inflate(
                R.layout.row_product, false
            ),
            onClickListener
        )

    override fun onBindViewHolder(holder: RowProductViewHolder, position: Int) {
        productList.let {
            holder.bindItem(it[position])
        }
    }

    override fun getItemCount() = productList.size

    fun setValues(productList: ArrayList<Results>?, onClickListener: OnClickListener) {
        this.productList = productList ?: arrayListOf()
        this.onClickListener = onClickListener
        this.notifyItemInserted(0)
    }
}