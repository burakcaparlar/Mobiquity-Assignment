package com.example.mobiquityassignment.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mobiquityassignment.R
import com.example.mobiquityassignment.core.ui.BaseFragment
import com.example.mobiquityassignment.databinding.FragmentProductDetailBinding
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {

    private val args: ProductDetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelAssistedFactory: ProductDetailViewModel.Factory
    private val productDetailViewModel: ProductDetailViewModel by viewModels {
        ProductDetailViewModel.provideFactory(viewModelAssistedFactory, args.productModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation: MaterialContainerTransform = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = 500
        }
        sharedElementEnterTransition = transformation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        with(productDetailViewModel) {
            getProductModelLiveData().observe(
                viewLifecycleOwner
            ) { productModel ->
                binding.productModel = productModel
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_product_detail
}