package com.example.mobiquityassignment.data.remote

import com.example.mobiquityassignment.data.remote.response.CategoryResponse
import javax.inject.Inject

class CategoriesDataSource @Inject constructor(
    private val categoriesService: CategoriesService
) {
    suspend fun fetchAllCategories(): List<CategoryResponse> =
        categoriesService.getCategories()
}