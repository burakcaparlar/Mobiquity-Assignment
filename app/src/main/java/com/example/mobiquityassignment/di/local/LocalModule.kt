package com.example.mobiquityassignment.di.local

import android.content.Context
import androidx.room.Room
import com.example.mobiquityassignment.data.local.db.ProductDAO
import com.example.mobiquityassignment.data.local.db.ProductDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideProductDB(@ApplicationContext context: Context): ProductDB = Room
        .databaseBuilder(context, ProductDB::class.java, ProductDB.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideProductDAO(db: ProductDB): ProductDAO = db.getProductDAO()
}