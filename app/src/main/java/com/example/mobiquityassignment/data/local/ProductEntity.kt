package com.example.mobiquityassignment.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.mobiquityassignment.data.domain.ProductModel
import com.squareup.moshi.JsonClass

@Entity(tableName = "product_table", primaryKeys = ["id"])
@JsonClass(generateAdapter = true)
data class ProductEntity(
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "categoryId") val categoryId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "salePrice") val salePrice: String
)

internal fun ProductEntity.toModel() =
    ProductModel(
        this.id,
        this.categoryId,
        this.name,
        this.url,
        this.description,
        this.salePrice
    )