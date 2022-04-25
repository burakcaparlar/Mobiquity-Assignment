package com.example.mobiquityassignment.data.remote

import com.example.mobiquityassignment.data.remote.response.CategoryResponse
import retrofit2.http.GET

interface CategoriesService {

    @GET(".")
    suspend fun getCategories(): List<CategoryResponse>
}