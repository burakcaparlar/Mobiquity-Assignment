package com.example.mobiquityassignment.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiquityassignment.core.ui.LayoutViewState
import com.example.mobiquityassignment.extension.doOnError
import com.example.mobiquityassignment.extension.doOnSuccess
import com.example.mobiquityassignment.usecase.CategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
) : ViewModel() {

    private val categoriesViewStateLiveData = MutableLiveData<CategoriesViewState>()

    private val layoutViewStateLiveData = MutableLiveData<LayoutViewState>()

    fun getCategoriesViewStateLiveData(): LiveData<CategoriesViewState> =
        categoriesViewStateLiveData

    fun getLayoutViewStateLiveData(): LiveData<LayoutViewState> = layoutViewStateLiveData

    fun getCategories() {
        viewModelScope.launch {
            categoriesUseCase.getCategories()
                .doOnSuccess {
                    categoriesViewStateLiveData.value = CategoriesViewState(it)
                }.doOnError {
                    it.printStackTrace()
                }.onEach {
                    layoutViewStateLiveData.value = LayoutViewState(it)
                }.launchIn(this)
        }
    }
}