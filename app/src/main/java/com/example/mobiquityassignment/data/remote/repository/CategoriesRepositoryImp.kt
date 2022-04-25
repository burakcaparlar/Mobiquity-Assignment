package com.example.mobiquityassignment.data.remote.repository

import com.example.mobiquityassignment.core.data.BaseRepository
import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.data.local.db.ProductDAO
import com.example.mobiquityassignment.data.local.toModel
import com.example.mobiquityassignment.data.remote.CategoriesDataSource
import com.example.mobiquityassignment.data.remote.response.toEntity
import com.example.mobiquityassignment.data.remote.response.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CategoriesRepositoryImp @Inject constructor(
    private val categoriesDataSource: CategoriesDataSource,
    private val productDAO: ProductDAO,
) : CategoriesRepository, BaseRepository() {

    override suspend fun fetchCategories(): Flow<State<List<CategoryModel>>> {
        return try {
            val responseList = categoriesDataSource.fetchAllCategories()
            if (responseList.isNotEmpty()) {
                productDAO.insertCategory(responseList.map { it.toEntity() })
                wrapFlowState { responseList.map { it.toModel() } }
            } else {
                wrapFlowState { productDAO.getCategories().map { it.toModel() } }
            }
        } catch (e: Exception) {
            // check local db
            val localList = productDAO.getCategories()
            return if (localList.isEmpty()) {
                // return error state if local db is empty
                flow {
                    e.printStackTrace()
                    emit(State.Error(e))
                }.flowOn(Dispatchers.IO)
            } else {
                // return local db content
                wrapFlowState {
                    localList.map { it.toModel() }
                }
            }
        }
    }
}