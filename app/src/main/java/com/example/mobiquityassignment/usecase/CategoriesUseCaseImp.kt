package com.example.mobiquityassignment.usecase

import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.data.remote.repository.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoriesUseCaseImp @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : CategoriesUseCase {

    override suspend fun getCategories(): Flow<State<List<CategoryModel>>> =
        categoriesRepository.fetchCategories()
}