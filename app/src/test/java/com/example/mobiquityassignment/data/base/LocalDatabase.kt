package com.example.mobiquityassignment.data.base

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.mobiquityassignment.data.local.db.ProductDB
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
abstract class LocalDatabase {

    lateinit var database: ProductDB

    @Before
    fun buildDatabase() {
        this.database = Room.inMemoryDatabaseBuilder(
            getApplicationContext(),
            ProductDB::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDatabase() {
        this.database.close()
    }
}