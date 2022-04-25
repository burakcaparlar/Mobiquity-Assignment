package com.example.mobiquityassignment.data.local.db

import androidx.room.*
import com.example.mobiquityassignment.data.local.CategoryEntity

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categories")
    suspend fun getCategories(): List<CategoryEntity>
}