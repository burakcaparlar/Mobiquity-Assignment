package com.example.mobiquityassignment.data.remote.response

import com.google.gson.annotations.SerializedName

data class SalePrice(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("currency")
    val currency: String
)