package com.example.mobiquityassignment.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobiquityassignment.data.local.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class ProductDB : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "categories"
    }

    abstract fun getProductDAO(): ProductDAO
}