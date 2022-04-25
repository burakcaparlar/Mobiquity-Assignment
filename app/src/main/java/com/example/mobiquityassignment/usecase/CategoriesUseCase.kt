package com.example.mobiquityassignment.usecase

import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.data.domain.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoriesUseCase {

    suspend fun getCategories(): Flow<State<List<CategoryModel>>>
}