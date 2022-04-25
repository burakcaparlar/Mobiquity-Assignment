package com.example.mobiquityassignment.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.databinding.ProductItemBinding
import com.example.mobiquityassignment.ui.categories.adapter.CategoriesRecyclerViewAdapter

class ProductsViewHolder(private val binding: ProductItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(productModel: ProductModel, productListClickListener: CategoriesRecyclerViewAdapter.ProductListClickListener?) {
        binding.productModel = productModel
        binding.productListClickListener = productListClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): ProductsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ProductItemBinding.inflate(
                inflater,
                parent,
                false
            )
            return ProductsViewHolder(binding)
        }
    }
}