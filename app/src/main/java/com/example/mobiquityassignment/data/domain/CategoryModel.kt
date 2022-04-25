package com.example.mobiquityassignment.data.domain

data class CategoryModel(
    val id: String,
    val name: String,
    val description: String,
    val productModels: List<ProductModel>?
)