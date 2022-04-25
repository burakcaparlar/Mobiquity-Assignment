package com.example.mobiquityassignment.data.remote.response

import com.example.mobiquityassignment.BuildConfig
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.data.local.ProductEntity
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("salePrice")
    val salePrice: SalePrice
)

internal fun ProductResponse.toModel(): ProductModel {
    return ProductModel(
        id = this.id,
        categoryId = this.categoryId,
        name = this.name,
        url = "${BuildConfig.BASE_URL}${this.url}",
        description = this.description,
        salePrice = "${this.salePrice.currency} ${this.salePrice.amount}"
    )
}

internal fun ProductResponse.toEntity() =
    ProductEntity(
        id = this.id,
        categoryId = this.categoryId,
        name = this.name,
        url = "${BuildConfig.BASE_URL}${this.url}",
        description = this.description,
        salePrice = "${this.salePrice.currency} ${this.salePrice.amount}"
    )