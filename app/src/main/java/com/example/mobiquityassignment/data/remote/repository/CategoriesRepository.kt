package com.example.mobiquityassignment.data.remote.repository

import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.data.domain.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    suspend fun fetchCategories(): Flow<State<List<CategoryModel>>>
}