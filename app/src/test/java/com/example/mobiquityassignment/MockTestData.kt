package com.example.mobiquityassignment

import com.example.mobiquityassignment.data.domain.CategoryModel
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.data.local.CategoryEntity
import com.example.mobiquityassignment.data.local.ProductEntity

object MockTestData {

    fun getMockCategories() = listOf(getMockCategoryModel())

    private fun getMockCategoryModel(): CategoryModel {
        return CategoryModel(id = "mockCategoryId",
            name = "mockCategoryName",
            description = "mockCategoryDesc",
            productModels = getMockProductModels())
    }

    private fun getMockProductModels(): List<ProductModel> =
        listOf(getMockProductModel())

    private fun getMockProductModel(): ProductModel {
        return ProductModel(id = "mockProductId",
            categoryId = "mockCategoryId",
            name = "mockProductName",
            url = "mockProductUrl",
            description = "mockProductDesc",
            salePrice = "mockProductSalePrice")
    }

    fun getMockCategoryEntities() = listOf(getMockCategoryEntity())

    private fun getMockCategoryEntity(): CategoryEntity {
        return CategoryEntity(
            id = "mockCategoryId",
            name = "mockCategoryName",
            description = "mockCategoryDesc",
            products = getMockProductEntities()
        )
    }

    private fun getMockProductEntities(): List<ProductEntity> = listOf(getMockProductEntity())

    private fun getMockProductEntity(): ProductEntity {
        return ProductEntity(
            id = "mockProductId",
            categoryId = "mockCategoryId",
            name = "mockProductName",
            url = "mockProductUrl",
            description = "mockProductDesc",
            salePrice = "mockProductSalePrice"
        )
    }
}