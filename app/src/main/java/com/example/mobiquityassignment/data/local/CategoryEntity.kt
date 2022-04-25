package com.example.mobiquityassignment.data.local

import androidx.room.*
import com.example.mobiquityassignment.data.domain.CategoryModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@Entity(tableName = "categories", primaryKeys = ["id"])
@TypeConverters(ProductEntityTypeConverter::class)
data class CategoryEntity(
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "products") val products: List<ProductEntity> = listOf()
)

internal class ProductEntityTypeConverter {
    private val type = Types.newParameterizedType(List::class.java, ProductEntity::class.java)
    private val adapter: JsonAdapter<List<ProductEntity>> = Moshi.Builder().build().adapter(type)

    @TypeConverter
    fun toList(data: String?) =
        data?.let { adapter.fromJson(it) } ?: listOf()

    @TypeConverter
    fun toString(someObjects: List<ProductEntity>): String =
        adapter.toJson(someObjects)
}

internal fun CategoryEntity.toModel() =
    CategoryModel(
        this.id,
        this.name,
        this.description,
        this.products.map { it.toModel() }
    )