package com.example.mobiquityassignment.ui.detail.adapter

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.ui.categories.adapter.CategoriesRecyclerViewAdapter

class ProductsRecyclerViewAdapter : ListAdapter<ProductModel, ProductsViewHolder>(DIFF_UTIL) {

    private var productListClickListener: CategoriesRecyclerViewAdapter.ProductListClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position), productListClickListener)
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["android:setProducts", "android:onProductsAdapterClick"])
        fun setProducts(
            view: RecyclerView?,
            products: List<ProductModel>?,
            productListClickListener: CategoriesRecyclerViewAdapter.ProductListClickListener?
        ) {
            view?.let {
                if (it.adapter == null) {
                    it.adapter = ProductsRecyclerViewAdapter()
                }
                (it.adapter as ProductsRecyclerViewAdapter).submitList(products)
                (it.adapter as ProductsRecyclerViewAdapter).addProductListClickListener(
                    productListClickListener
                )
            }
        }

        val DIFF_UTIL = object : DiffUtil.ItemCallback<ProductModel>() {
            override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun addProductListClickListener(productListClickListener: CategoriesRecyclerViewAdapter.ProductListClickListener?) {
        this.productListClickListener = productListClickListener
    }
}