package com.example.mobiquityassignment.ui.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.mobiquityassignment.R
import com.example.mobiquityassignment.core.ui.BaseFragment
import com.example.mobiquityassignment.core.ui.LayoutViewState
import com.example.mobiquityassignment.data.domain.ProductModel
import com.example.mobiquityassignment.databinding.FragmentCategoriesBinding
import com.example.mobiquityassignment.extension.getButtonErrorAction
import com.example.mobiquityassignment.extension.inflate
import com.example.mobiquityassignment.ui.categories.adapter.CategoriesRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {

    private val categoriesViewModel: CategoriesViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_categories

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpViewModel()
        getCategories()
    }

    private fun setUpView() {
        with(binding) {
            swipeRefreshLayout.setOnRefreshListener {
                getCategories()
            }

            layoutError.setOnInflateListener { _, _ ->
                getButtonErrorAction()?.setOnClickListener { getCategories() }
            }

            productListClickListener =
                object : CategoriesRecyclerViewAdapter.ProductListClickListener {
                    override fun onProductClicked(productModel: ProductModel) {
                        navigateToProductDetail(productModel)
                    }
                }
        }
    }

    private fun navigateToProductDetail(productModel: ProductModel) {
        view?.findNavController()?.navigate(
            CategoriesFragmentDirections.actionCategoriesToProductDetail(
                productModel
            )
        )
    }

    private fun setUpViewModel() {
        setHasOptionsMenu(true)
        with(categoriesViewModel) {
            getLayoutViewStateLiveData().observe(
                viewLifecycleOwner
            ) { layoutViewState ->
                binding.layoutViewState = layoutViewState
                binding.executePendingBindings()
                inflateLayoutError(layoutViewState)
            }

            getCategoriesViewStateLiveData().observe(
                viewLifecycleOwner
            ) { categoriesViewState ->
                binding.viewState = categoriesViewState
                binding.executePendingBindings()
            }
        }
    }

    private fun inflateLayoutError(layoutViewState: LayoutViewState) {
        binding.layoutError.viewStub?.inflate(layoutViewState.isError())
    }

    private fun getCategories() {
        categoriesViewModel.getCategories()
    }
}