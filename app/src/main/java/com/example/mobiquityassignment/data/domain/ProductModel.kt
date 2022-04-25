package com.example.mobiquityassignment.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: String,
    val categoryId: String,
    val name: String?,
    val url: String?,
    val description: String,
    val salePrice: String
) : Parcelable