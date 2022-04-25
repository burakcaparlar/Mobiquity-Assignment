package com.example.mobiquityassignment.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.mobiquityassignment.MockTestData
import com.example.mobiquityassignment.core.data.State
import com.example.mobiquityassignment.core.ui.LayoutViewState
import com.example.mobiquityassignment.ui.categories.CategoriesViewModel
import com.example.mobiquityassignment.ui.categories.CategoriesViewState
import com.example.mobiquityassignment.usecase.CategoriesUseCase
import com.example.mobiquityassignment.util.CoroutinesTestRule
import com.example.mobiquityassignment.util.`should be`
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.SocketTimeoutException

@ExperimentalCoroutinesApi
class CategoriesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private lateinit var categoriesViewModel: CategoriesViewModel

    private val categoriesUseCase = mockk<CategoriesUseCase>()
    private val categoriesViewStateLiveDataObserver = mockk<Observer<CategoriesViewState>>()
    private val categoriesViewStateLiveDataSlot = slot<CategoriesViewState>()
    private val categoriesViewStateLiveDataValues = arrayListOf<CategoriesViewState>()

    private val layoutViewStateLiveDataObserver = mockk<Observer<LayoutViewState>>()
    private val layoutViewStateLiveDataSlot = slot<LayoutViewState>()
    private val layoutViewStateLiveDataValues = arrayListOf<LayoutViewState>()

    @Before
    fun setup() {
        categoriesViewModel = CategoriesViewModel(categoriesUseCase)
    }

    @Test
    fun `check getCategories() success case`() {

        //Given
        val categories = MockTestData.getMockCategories()

        categoriesViewModel.getCategoriesViewStateLiveData()
            .observeForever(categoriesViewStateLiveDataObserver)
        categoriesViewModel.getLayoutViewStateLiveData().observeForever(layoutViewStateLiveDataObserver)

        every { categoriesViewStateLiveDataObserver.onChanged(capture(categoriesViewStateLiveDataSlot)) } answers {
            categoriesViewStateLiveDataValues.add(
                categoriesViewStateLiveDataSlot.captured
            )
        }
        every { layoutViewStateLiveDataObserver.onChanged(capture(layoutViewStateLiveDataSlot)) } answers {
            layoutViewStateLiveDataValues.add(
                layoutViewStateLiveDataSlot.captured
            )
        }
        coEvery { categoriesUseCase.getCategories() } returns flow {
            emit(State.Loading)
            emit(State.Success(categories))
        }

        //When
        categoriesViewModel.getCategories()

        //Then
        categoriesViewStateLiveDataValues[0].getCategories() `should be` categories
        categoriesViewStateLiveDataValues.size `should be` 1

        layoutViewStateLiveDataValues[0].isLoading() `should be` true
        layoutViewStateLiveDataValues[1].isSuccess() `should be` true

        coVerify(exactly = 1) { categoriesUseCase.getCategories() }
    }

    @Test
    fun `check getCategories() fail case`() {

        //Given
        val error = SocketTimeoutException()

        categoriesViewModel.getCategoriesViewStateLiveData()
            .observeForever(categoriesViewStateLiveDataObserver)
        categoriesViewModel.getLayoutViewStateLiveData().observeForever(layoutViewStateLiveDataObserver)

        every { categoriesViewStateLiveDataObserver.onChanged(capture(categoriesViewStateLiveDataSlot)) } answers {
            categoriesViewStateLiveDataValues.add(
                categoriesViewStateLiveDataSlot.captured
            )
        }
        every { layoutViewStateLiveDataObserver.onChanged(capture(layoutViewStateLiveDataSlot)) } answers {
            layoutViewStateLiveDataValues.add(layoutViewStateLiveDataSlot.captured)
        }

        coEvery { categoriesUseCase.getCategories() } returns flow {
            emit(State.Loading)
            emit(State.Error(error))
        }

        //When
        categoriesViewModel.getCategories()

        //Then
        categoriesViewStateLiveDataValues.size `should be` 0

        layoutViewStateLiveDataValues[0].isLoading() `should be` true
        layoutViewStateLiveDataValues[1].isError() `should be` true

        coVerify(exactly = 1) { categoriesUseCase.getCategories() }
    }
}