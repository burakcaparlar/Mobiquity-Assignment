package com.example.mobiquityassignment.ui.detail

import androidx.lifecycle.*
import com.example.mobiquityassignment.data.domain.ProductModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ProductDetailViewModel @AssistedInject constructor(
    @Assisted private val productModel: ProductModel
) : ViewModel() {

    private val productModelLiveData = MutableLiveData<ProductModel>()

    fun getProductModelLiveData(): LiveData<ProductModel> = productModelLiveData

    init {
        setProductDetail()
    }

    @AssistedFactory
    interface Factory {
        fun create(productModel: ProductModel): ProductDetailViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            productModel: ProductModel
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(productModel) as T
            }
        }
    }

    private fun setProductDetail() {
        productModelLiveData.value = productModel
    }
}