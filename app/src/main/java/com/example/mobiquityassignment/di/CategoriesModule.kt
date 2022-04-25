package com.example.mobiquityassignment.di

import com.example.mobiquityassignment.data.remote.CategoriesService
import com.example.mobiquityassignment.data.remote.repository.CategoriesRepository
import com.example.mobiquityassignment.data.remote.repository.CategoriesRepositoryImp
import com.example.mobiquityassignment.usecase.CategoriesUseCase
import com.example.mobiquityassignment.usecase.CategoriesUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoriesModule {

    @Binds
    abstract fun provideCategoriesRepository(
        categoriesRepositoryImp: CategoriesRepositoryImp
    ): CategoriesRepository

    @Binds
    abstract fun provideCategoriesUseCaseImp(
        categoriesUseCaseImp: CategoriesUseCaseImp
    ): CategoriesUseCase

    companion object {

        @Provides
        fun provideCategoriesService(
            retrofit: Retrofit
        ): CategoriesService = retrofit.create(CategoriesService::class.java)
    }
}