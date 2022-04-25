package com.example.mobiquityassignment.ui.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.databinding.CategoryItemBinding

class CategoriesViewHolder(private val binding: CategoryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(categoryModel: CategoryModel, productListClickListener: CategoriesRecyclerViewAdapter.ProductListClickListener?) {
        binding.categoryModel = categoryModel
        binding.productListClickListener = productListClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): CategoriesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CategoryItemBinding.inflate(
                inflater,
                parent,
                false
            )
            return CategoriesViewHolder(binding)
        }
    }
}