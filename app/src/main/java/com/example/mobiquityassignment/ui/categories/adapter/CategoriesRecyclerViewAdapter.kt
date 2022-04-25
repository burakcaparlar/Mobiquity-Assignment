package com.example.mobiquityassignment.ui.categories.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mobiquityassignment.R
import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.ui.categories.layoutmanager.GridAutoFitLayoutManager

class CategoriesRecyclerViewAdapter : ListAdapter<CategoryModel, CategoriesViewHolder>(DIFF_UTIL) {

    private var productListClickListener: ProductListClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position), productListClickListener)
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["android:setCategories", "android:onProductsAdapterClick"])
        fun setCategories(
            view: RecyclerView?,
            categoryList: List<CategoryModel>?,
            productListClickListener: ProductListClickListener?
        ) {
            view?.let {
                if (it.adapter == null) {
                    it.adapter = CategoriesRecyclerViewAdapter()
                }

                view.context?.let { context ->
                    val columnWidth = context.resources.getDimension(R.dimen.column_size).toInt()
                    it.layoutManager = GridAutoFitLayoutManager(context, columnWidth)
                }

                (it.adapter as CategoriesRecyclerViewAdapter).submitList(categoryList)
                (it.adapter as CategoriesRecyclerViewAdapter).addProductListClickListener(
                    productListClickListener
                )
            }
        }

        val DIFF_UTIL = object : DiffUtil.ItemCallback<CategoryModel>() {
            override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun addProductListClickListener(productListClickListener: ProductListClickListener?) {
        this.productListClickListener = productListClickListener
    }


    interface ProductListClickListener {
        fun onProductClicked(productModel: ProductModel)
    }
}