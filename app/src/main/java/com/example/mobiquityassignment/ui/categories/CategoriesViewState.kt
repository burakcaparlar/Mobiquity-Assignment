package com.example.mobiquityassignment.ui.categories

import com.example.mobiquityassignment.data.domain.CategoryModel

class CategoriesViewState(
    private val categories: List<CategoryModel>
) {

    fun getCategories() = categories
}