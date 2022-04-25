package com.example.mobiquityassignment.data.remote.response

import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.data.local.CategoryEntity
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("products")
    val products: List<ProductResponse>?
)
internal fun CategoryResponse.toModel(): CategoryModel {
    return CategoryModel(
        id = this.id,
        name = this.name,
        description = this.description,
        productModels = this.products?.map { it.toModel() } ?: listOf()
    )
}

internal fun CategoryResponse.toEntity() =
    CategoryEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        products = this.products?.map { it.toEntity() } ?: listOf()
    )